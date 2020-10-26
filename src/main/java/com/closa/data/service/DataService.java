package com.closa.data.service;

import com.closa.data.dao.mgRepository;
import com.closa.data.dto.SMNU01oDTO;
import com.closa.data.model.MenuGroup;
import com.closa.global.dto.GlobaliDTO;
import com.closa.global.functions.PagingHelper;
import com.closa.global.throwables.AppException;
import com.closa.global.throwables.MessageCode;
import com.closa.global.throwables.exceptions.UnexpectedEmptyResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DataService {

    @Autowired
    mgRepository mgRepository;

    @Autowired
    PagingHelper ph ;

    public SMNU01oDTO dealWithGetMenu(GlobaliDTO iDto) throws AppException {
        SMNU01oDTO oDto = new SMNU01oDTO();
        Pageable pageable = ph.buildThePageable(iDto);
        if (pageable == null ){
            List<MenuGroup> list = mgRepository.findAll();
            oDto.getMenuGroups().addAll(list);
            oDto.setReturnCode(MessageCode.APP0000.getrCode());
        }
        else {
            Page<MenuGroup> list = mgRepository.findAll(pageable);
            oDto.setReturnCode(MessageCode.APP0008.getrCode());
            oDto.setTotalNumberOfItems(list.getTotalElements());
            oDto.setTotalNumberOfPages(list.getTotalPages());
            oDto.setLastItemsProvided(list.getNumberOfElements());
            if(list.getNumberOfElements()== 0){
                throw new UnexpectedEmptyResultException("SMNU01/2");
            }
            oDto.getMenuGroups().addAll(list.getContent());
            oDto.setReturnCode(MessageCode.APP0000.getrCode());
        }

        return oDto;
    }
}
