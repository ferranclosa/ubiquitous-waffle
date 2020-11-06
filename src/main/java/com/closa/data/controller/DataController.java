package com.closa.data.controller;

import com.closa.data.dto.*;
import com.closa.data.service.DataService;
import com.closa.global.dto.GlobaliDTO;
import com.closa.global.dto.GlobaloDTO;
import com.closa.global.status.dto.SDTA01oDTO;
import com.closa.global.throwables.AppException;
import com.closa.global.throwables.AppMessage;
import com.closa.global.throwables.MessageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
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

    @CrossOrigin
    @PostMapping(value ="/SMNU03/createAMenuGroup",  consumes= MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GlobaloDTO createGroup(@RequestBody SMNU03iDTO iDto ){
        Instant inFirst = Instant.now();
        GlobaloDTO oDto = new GlobaloDTO();
        logger.info("[SMNU03] iDto (input) : " + iDto.toJson());

        try {
            oDto = dataService.dealWithCreateGroup(iDto);
        } catch (AppException e ) {
            oDto.setReturnCode(e.getrCode());
            oDto.setReturnLabel(e.getMessageText() );

        } catch (Exception e){
            oDto.setReturnCode(MessageCode.APP0099.getrCode());
            oDto.setReturnLabel(MessageCode.APP0099.getmMsg());
            e.printStackTrace();

        }
        Instant inLast = Instant.now();

        logger.info("[SMNU03] oDto (output)  : " + oDto.toJson());
        logger.info("[SMNU03] Duration  : " + Duration.between(inFirst , inLast).toMillis() + " milliseconds" ) ;

        return oDto;

    }
    @CrossOrigin
    @PostMapping(value ="/SMNU04/deleteAMenuGroup",  consumes= MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GlobaloDTO deleteGroup(@RequestBody SMNU04iDTO iDto ){
        Instant inFirst = Instant.now();
        GlobaloDTO oDto = new GlobaloDTO();
        logger.info("[SMNU04-Delete a Group] iDto (input) : " + iDto.toJson());

        try {
            oDto = dataService.dealWithDeleteGroup(iDto);
        } catch (AppException e ) {
            oDto.setReturnCode(e.getrCode());
            oDto.setReturnLabel(e.getMessageText() );

        } catch (Exception e){
            oDto.setReturnCode(MessageCode.APP0099.getrCode());
            oDto.setReturnLabel(MessageCode.APP0099.getmMsg());
            e.printStackTrace();

        }
        Instant inLast = Instant.now();

        logger.info("[SMNU04] oDto (output)  : " + oDto.toJson());
        logger.info("[SMNU04] Duration  : " + Duration.between(inFirst , inLast).toMillis() + " milliseconds" ) ;

        return oDto;

    }

    @CrossOrigin
    @PostMapping(value ="/SMNU06/updateAMenuGroup",  consumes= MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GlobaloDTO updateGroup(@RequestBody SMNU06iDTO iDto ){
        Instant inFirst = Instant.now();
        GlobaloDTO oDto = new GlobaloDTO();
        logger.info("[SMNU06-Update a Group] iDto (input) : " + iDto.toJson());

        try {
            oDto = dataService.dealWithUpdateGroup(iDto);
        } catch (AppException e ) {
            oDto.setReturnCode(e.getrCode());
            oDto.setReturnLabel(e.getMessageText() );

        } catch (Exception e){
            oDto.setReturnCode(MessageCode.APP0099.getrCode());
            oDto.setReturnLabel(MessageCode.APP0099.getmMsg());
            e.printStackTrace();

        }
        Instant inLast = Instant.now();

        logger.info("[SMNU06] oDto (output)  : " + oDto.toJson());
        logger.info("[SMNU06] Duration  : " + Duration.between(inFirst , inLast).toMillis() + " milliseconds" ) ;

        return oDto;

    }
    @CrossOrigin
    @GetMapping(value = "/SDTA01/getStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public SDTA01oDTO getStatus(){
        SDTA01oDTO oDto = new SDTA01oDTO();
        Instant inFirst = Instant.now();
        logger.info("[SDTA01] Start ");

        try {
            oDto = dataService.dealWithGetStatus();
        } catch (AppException e ) {
            oDto.setReturnCode(e.getrCode());
            oDto.setReturnLabel(e.getMessageText() );

        } catch (Exception e){
            oDto.setReturnCode(MessageCode.APP0099.getrCode());
            oDto.setReturnLabel(MessageCode.APP0099.getmMsg());
            e.printStackTrace();

        }
        Instant inLast = Instant.now();

        logger.info("[SDTA01] oDto (output)  : " + oDto.toJson());
        logger.info("[SDTA01] Duration  : " + Duration.between(inFirst , inLast).toMillis() + " milliseconds" ) ;

        return oDto;


    }

    @CrossOrigin
    @PostMapping(value ="/SMNU07/getAllFunctionsInGroups",  consumes= MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SMNU07oDTO getAllFunctionsInGroups(@RequestBody SMNU07iDTO iDto ){
        Instant inFirst = Instant.now();
        SMNU07oDTO oDto = new SMNU07oDTO();
        logger.info("[SMNU07] iDto (input) : " + iDto.toJson());

        try {
            oDto = dataService.dealWithFunctionsByGroup(iDto);
        } catch (AppException e ) {
            oDto.setReturnCode(e.getMessageCode().getrCode());
            oDto.setReturnLabel(e.getMessageCode().getmMsg() );

        } catch (Exception e){
            oDto.setReturnCode(MessageCode.APP0099.getrCode());
            oDto.setReturnLabel(MessageCode.APP0099.getmMsg());
            e.printStackTrace();

        } catch (AppMessage e) {
            oDto.setReturnCode(e.getMessageCode().getrCode());
            oDto.setReturnLabel(e.getMessageCode().getmMsg() );
        }
        Instant inLast = Instant.now();

        logger.info("[SMNU07] oDto (output)  : " + oDto.toJson());
        logger.info("[SMNU07] Duration  : " + Duration.between(inFirst , inLast).toMillis() + " milliseconds" ) ;

        return oDto;

    }

    @CrossOrigin
    @PostMapping(value ="/SMNU08/findAllFunctions",  consumes= MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SMNU07oDTO findAllFunctions(@RequestBody GlobaliDTO iDto ){
        Instant inFirst = Instant.now();
        SMNU07oDTO oDto = new SMNU07oDTO();
        logger.info("[SMNU08] iDto (input) : " + iDto.toJson());

        try {
            oDto = dataService.dealWithGetAllFunctions(iDto);
        } catch (AppException e ) {
            oDto.setReturnCode(e.getrCode());
            oDto.setReturnLabel(e.getMessageText() );

        } catch (Exception e){
            oDto.setReturnCode(MessageCode.APP0099.getrCode());
            oDto.setReturnLabel(MessageCode.APP0099.getmMsg());
            e.printStackTrace();

        }
        Instant inLast = Instant.now();

        logger.info("[SMNU08] oDto (output)  : " + oDto.toJson());
        logger.info("[SMNU08] Duration  : " + Duration.between(inFirst , inLast).toMillis() + " milliseconds" ) ;

        return oDto;

    }


}
