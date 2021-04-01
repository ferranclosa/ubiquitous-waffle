package com.closa.data.service;

import com.closa.data.dao.maRepository;
import com.closa.data.dao.mfRepository;
import com.closa.data.dao.mgRepository;
import com.closa.data.dto.*;
import com.closa.data.model.MenuApp;
import com.closa.data.model.MenuFunction;
import com.closa.data.model.MenuGroup;
import com.closa.global.dto.GlobaliDTO;
import com.closa.global.dto.GlobaloDTO;
import com.closa.global.functions.PagingHelper;
import com.closa.global.status.dao.ScdRepository;
import com.closa.global.status.dto.SDTA01oDTO;
import com.closa.global.status.model.bo.BoStatus;
import com.closa.global.status.model.enums.Status;
import com.closa.global.status.util.StatusHelper;
import com.closa.global.throwables.AppException;
import com.closa.global.throwables.AppMessage;
import com.closa.global.throwables.MessageCode;
import com.closa.global.throwables.exceptions.ItemAlreadyExistsException;
import com.closa.global.throwables.exceptions.ItemNotFoundException;
import com.closa.global.throwables.exceptions.UnexpectedEmptyResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DataService {

    @Autowired
    mgRepository mgRepository;

    @Autowired
    mfRepository mfRepository;

    @Autowired
    maRepository maRepository;

    @Autowired
    ScdRepository stsRepo;

    @Autowired
    PagingHelper ph;

    @Autowired
    StatusHelper sh;

    public SMNU01oDTO dealWithGetMenu(GlobaliDTO iDto) throws AppException {
        SMNU01oDTO oDto = new SMNU01oDTO();
        Pageable pageable = ph.buildThePageable(iDto);
        if (pageable == null) {
            List<MenuGroup> list = mgRepository.findAll();
            oDto.getMenuGroups().addAll(list);
            oDto.setReturnCode(MessageCode.APP0000.getrCode());
        } else {
            Page<MenuGroup> list = mgRepository.findAll(pageable);
            oDto.setReturnCode(MessageCode.APP0008.getrCode());
            oDto.setTotalNumberOfItems(list.getTotalElements());
            oDto.setTotalNumberOfPages(list.getTotalPages());
            oDto.setLastItemsProvided(list.getNumberOfElements());
            if (list.getNumberOfElements() == 0) {
                throw new UnexpectedEmptyResultException("SMNU01/2");
            }
            oDto.getMenuGroups().addAll(list.getContent());
            oDto.setReturnCode(MessageCode.APP0000.getrCode());
        }

        return oDto;
    }

    public SDTA01oDTO dealWithGetStatus() throws AppException {

        SDTA01oDTO oDTO = new SDTA01oDTO();
        List<BoStatus> list = stsRepo.provideDynamicStatus();

        for (BoStatus one : list) {

            one.setCompositeStatus(one.getCompositeStatus());
            one.setDescription(one.getDescription());
            one.setCases(one.getTheFullObject().getUseCases());
            oDTO.getListOfDynamicStatus().add(one);
        }
        oDTO.setReturnCode(MessageCode.APP0000.getrCode());
        return oDTO;
    }

    public GlobaloDTO dealWithCreateGroup(SMNU03iDTO iDto) throws AppException {
        GlobaloDTO oDto = new GlobaloDTO();
        Optional<MenuGroup> ogrp = mgRepository.findByMgCode(iDto.getMgCode());
        if (ogrp.isPresent()) {
            throw new ItemAlreadyExistsException(iDto.toJson());
        } else {
            MenuGroup mg = new MenuGroup();
            mg.setMgCode(iDto.getMgCode());
            mg.setMgLabel(iDto.getMgLabel());
            mg.setMgRoute(iDto.getMgRoute());
            mg.setMgSortBy(iDto.getMgSortBy());
            mg.setMgDescription(iDto.getMgDescription());
            mg.setMgStatus(sh.setItemStatus(iDto.getMgStatus()));
            mgRepository.save(mg);
            oDto.setReturnCode(MessageCode.APP0000.getrCode());
            oDto.setReturnLabel(MessageCode.APP0000.getmMsg());
        }
        return oDto;
    }

    public GlobaloDTO dealWithDeleteGroup(SMNU04iDTO iDto) throws AppException    {
    GlobaloDTO oDto  = new GlobaloDTO();
        Optional<MenuGroup> ogrp = mgRepository.findById(iDto.getId());
        if (!ogrp.isPresent()) {
            throw new ItemNotFoundException(iDto.toJson());
        } else {
            MenuGroup mg = ogrp.get();
            mg.setMgStatus(sh.setItemStatus(Status.DELETED));
            mg.setMgActive(false);
            mgRepository.save(mg);
            oDto.setReturnCode(MessageCode.APP0000.getrCode());
            oDto.setReturnLabel(MessageCode.APP0000.getmMsg());
        }

    return oDto; }

    public GlobaloDTO dealWithUpdateGroup(SMNU06iDTO iDto) throws AppException {
        GlobaloDTO oDto = new GlobaloDTO();
        Optional<MenuGroup> ogrp = mgRepository.findById(iDto.getId());
        if (!ogrp.isPresent()) {
            throw new ItemNotFoundException(iDto.toJson());
        } else {
            MenuGroup mg = ogrp.get();
            mg.setMgDescription(iDto.getMgDescription());
            mg.setMgLabel(iDto.getMgLabel());
            mg.setMgStatus(sh.setItemStatus(iDto.getMgStatus().getFullStatus()));
            mg.setMgSortBy(iDto.getMgSortBy());
            mg.setMgRoute(iDto.getMgRoute());

            mg.setMgActive(sh.isActive(mg.getMgStatus()));
            mgRepository.save(mg);
            oDto.setReturnCode(MessageCode.APP0000.getrCode());
            oDto.setReturnLabel(MessageCode.APP0000.getmMsg());
        }

        return oDto;
    }

    public SMNU07oDTO dealWithFunctionsByGroup(SMNU07iDTO iDto) throws AppException, AppMessage {
        SMNU07oDTO oDTO = new SMNU07oDTO();
        Pageable pageable = ph.buildThePageable(iDto);
        if (pageable == null) {

        } else {
            Optional<MenuGroup> ogrp = mgRepository.findById(iDto.getGroupId());
            if (ogrp.isPresent()) {
                Page<MenuFunction> list = mfRepository.getAllByMfGroup(ogrp.get(), pageable);
                oDTO.getListOfMenuFunctions().addAll(list.getContent());
                oDTO.setTotalNumberOfItems(list.getTotalElements());
                oDTO.setTotalNumberOfPages(list.getTotalPages());
                oDTO.setLastItemsProvided(list.getNumberOfElements());
                oDTO.setReturnCode(MessageCode.APP0009.getrCode());
                oDTO.setReturnLabel(MessageCode.APP0009.getmMsg());
            } else {
                throw new ItemNotFoundException("Group Id = " + iDto.getGroupId());
            }
        }
        return oDTO;
    }

    public SMNU07oDTO dealWithGetAllFunctions(GlobaliDTO iDto) throws AppException{
        SMNU07oDTO oDto = new SMNU07oDTO();

        Pageable pageable = ph.buildThePageable(iDto);
        if (pageable == null) {
            List<MenuFunction> list = mfRepository.findAll();
            oDto.getListOfMenuFunctions().addAll(list);
            oDto.setReturnCode(MessageCode.APP0000.getrCode());

        } else {
            Page<MenuFunction> list = mfRepository.findAll(pageable);
            oDto.setReturnCode(MessageCode.APP0008.getrCode());
            oDto.setTotalNumberOfItems(list.getTotalElements());
            oDto.setTotalNumberOfPages(list.getTotalPages());
            oDto.setLastItemsProvided(list.getNumberOfElements());
            if (list.getNumberOfElements() == 0) {
                throw new UnexpectedEmptyResultException("SMNU01/2");
            }
            oDto.getListOfMenuFunctions().addAll(list.getContent());
            oDto.setReturnCode(MessageCode.APP0009.getrCode());
        }

        return oDto;


    }

    public SMNU10oDTO dealWithGetApps(GlobaliDTO iDto) throws AppException {
        SMNU10oDTO oDto = new SMNU10oDTO();
        Pageable pageable = ph.buildThePageable(iDto);
        if (pageable == null) {
            List<MenuApp> list = maRepository.findAll();
            oDto.getMenuApps().addAll(list);
            oDto.setReturnCode(MessageCode.APP0000.getrCode());

        } else {
            Page<MenuApp> list = maRepository.findAll(pageable);
            oDto.setReturnCode(MessageCode.APP0008.getrCode());
            oDto.setTotalNumberOfItems(list.getTotalElements());
            oDto.setTotalNumberOfPages(list.getTotalPages());
            oDto.setLastItemsProvided(list.getNumberOfElements());
            if (list.getNumberOfElements() == 0) {
                throw new UnexpectedEmptyResultException("SMNU10");
            }
            oDto.getMenuApps().addAll(list.getContent());
            oDto.setReturnCode(MessageCode.APP0009.getrCode());
        }

        return oDto;
    }
}
