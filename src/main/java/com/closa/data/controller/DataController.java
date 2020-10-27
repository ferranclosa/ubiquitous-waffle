package com.closa.data.controller;

import com.closa.data.dto.SMNU01oDTO;
import com.closa.data.service.DataService;
import com.closa.global.dto.GlobaliDTO;
import com.closa.global.dto.StandardQuery;
import com.closa.global.throwables.AppException;
import com.closa.global.throwables.MessageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.logging.Logger;

@RestController
public class DataController {

    private static final Logger logger = Logger.getLogger(DataController.class.getName());

    @Autowired
    DataService dataService;

    @CrossOrigin
    @PostMapping(value ="/open/SMNU01/getAllFunctionGroups",  consumes= MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SMNU01oDTO provideMenus(@RequestBody GlobaliDTO iDto ){
        Instant inFirst = Instant.now();
        SMNU01oDTO oDto = new SMNU01oDTO();
        logger.info("[SMNU01] iDto (input) : " + iDto.toJson());

        try {
            oDto = dataService.dealWithGetMenu(iDto);
        } catch (AppException e ) {
            oDto.setReturnCode(e.getrCode());
            oDto.setReturnLabel(e.getMessageText() );

         } catch (Exception e){
            oDto.setReturnCode(MessageCode.APP0099.getrCode());
            oDto.setReturnLabel(MessageCode.APP0099.getmMsg());
            e.printStackTrace();

        }
        Instant inLast = Instant.now();

        logger.info("[SMNU01] oDto (output)  : " + oDto.toJson());
        logger.info("[SMNU01] Duration  : " + Duration.between(inFirst , inLast).toMillis() + " milliseconds" ) ;

    return oDto;

    }

    @CrossOrigin
    @PostMapping(value ="/SMNU02/getAllGroups",  consumes= MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SMNU01oDTO provideMenusSecured(@RequestBody GlobaliDTO iDto ){
        Instant inFirst = Instant.now();
        SMNU01oDTO oDto = new SMNU01oDTO();
        logger.info("[SMNU02] iDto (input) : " + iDto.toJson());

        try {
            oDto = dataService.dealWithGetMenu(iDto);
        } catch (AppException e ) {
            oDto.setReturnCode(e.getrCode());
            oDto.setReturnLabel(e.getMessageText() );

        } catch (Exception e){
            oDto.setReturnCode(MessageCode.APP0099.getrCode());
            oDto.setReturnLabel(MessageCode.APP0099.getmMsg());
            e.printStackTrace();

        }
        Instant inLast = Instant.now();

        logger.info("[SMNU02] oDto (output)  : " + oDto.toJson());
        logger.info("[SMNU02] Duration  : " + Duration.between(inFirst , inLast).toMillis() + " milliseconds" ) ;

        return oDto;

    }

}
