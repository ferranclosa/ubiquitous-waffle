package com.closa.data.service;

import com.closa.data.dao.maRepository;
import com.closa.data.dao.mfRepository;
import com.closa.data.dao.mgRepository;
import com.closa.data.dao.moRepository;
import com.closa.data.model.MenuApp;
import com.closa.data.model.MenuFunction;
import com.closa.data.model.MenuGroup;
import com.closa.data.model.MenuOption;
import com.closa.global.status.model.enums.Status;
import com.closa.global.status.util.StatusHelper;
import com.closa.global.trace.model.enums.EventsHandled;
import com.closa.global.trace.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
public class DataLoaderMenus implements CommandLineRunner {

    @Autowired
    StatusHelper sh;
    @Autowired
    maRepository maRepository;
    @Autowired
    mgRepository mgRepository;

    @Autowired
    moRepository moRepository;

    @Autowired
    mfRepository mfRepository;
    @Autowired
    EventService evtService;

    @Override
    public void run(String... args) throws Exception {

        if (maRepository.count() == 0) {

            MenuOption mo = new MenuOption();
            mo.setMoCode("O2");
            mo.setMoLabel("Change");
            mo.setMoDescription("Update");
            mo.setMoSortBy(9);
            mo.setMoStatus(sh.setItemStatus(Status.ACTIVE));

            moRepository.save(mo);

            mo = new MenuOption();
            mo.setMoCode("F6");
            mo.setMoLabel("Add");
            mo.setMoDescription("CREATE");
            mo.setMoSortBy(8);
            mo.setMoStatus(sh.setItemStatus(Status.ACTIVE));

            moRepository.save(mo);

            mo = new MenuOption();
            mo.setMoCode("O4");
            mo.setMoLabel("Delete");
            mo.setMoDescription("DELETE");
            mo.setMoSortBy(7);
            mo.setMoStatus(sh.setItemStatus(Status.ACTIVE));

            moRepository.save(mo);

            mo = new MenuOption();
            mo.setMoCode("O5");
            mo.setMoLabel("View");
            mo.setMoDescription("VIEW");
            mo.setMoSortBy(6);
            mo.setMoStatus(sh.setItemStatus(Status.ACTIVE));

            moRepository.save(mo);

            mo = new MenuOption();
            mo.setMoCode("O3");
            mo.setMoLabel("Copy");
            mo.setMoDescription("COPY");
            mo.setMoSortBy(5);
            mo.setMoStatus(sh.setItemStatus(Status.ACTIVE));
            moRepository.save(mo);

            mo = new MenuOption();
            mo.setMoCode("O6");
            mo.setMoLabel("Upload");
            mo.setMoDescription("UPLOAD");
            mo.setMoSortBy(4);
            mo.setMoStatus(sh.setItemStatus(Status.ACTIVE));
            moRepository.save(mo);

            mo = new MenuOption();
            mo.setMoCode("O7");
            mo.setMoLabel("Download");
            mo.setMoDescription("DOWNLOAD");
            mo.setMoSortBy(3);
            mo.setMoStatus(sh.setItemStatus(Status.ACTIVE));
            moRepository.save(mo);

            MenuApp ma = new MenuApp();
            ma.setMaApplication("core");
            ma.setMaIsAccessSecured(false);
            ma.setMaStatus(sh.setItemStatus(Status.ACTIVE));
            maRepository.save(ma);
            evtService.insertEvent("04695798", EventsHandled.CREATED, ma.toJson());

            MenuGroup mg = new MenuGroup();
            mg.setMenuApp(ma);
            mg.setMgCode("Z");
            mg.setMgLabel("Work with Menus");
            mg.setMgRoute("/route_Z");
            mg.setMgSortBy(Integer.MAX_VALUE);
            mg.setMgStatus(sh.setItemStatus(Status.ACTIVE));
            mgRepository.save(mg);
            evtService.insertEvent("04695798", EventsHandled.CREATED, mg.toJson());



            MenuFunction mf = new MenuFunction();
            mf.setMfGroup(mg);
            mf.setMfCode("Z1");
            mf.setMfRoute("/route_Z1");
            mf.setMfLabel("Menu Apps");
            mf.setMfSortBy(1);
            mf.setMfStatus(sh.setItemStatus(Status.ACTIVE));
            mf.addOption(moRepository.findByMoCode("F6"));
            mf.addOption(moRepository.findByMoCode("O5"));
            mf.addOption(moRepository.findByMoCode("O2"));
            mf.addOption(moRepository.findByMoCode("O4"));

            mfRepository.save(mf);
            evtService.insertEvent("04695798", EventsHandled.CREATED, mf.toJson());



            mf = new MenuFunction();
            mf.setMfGroup(mg);
            mf.setMfCode("Z2");
            mf.setMfLabel("Menu Groups");
            mf.setMfRoute("/route_Z2");
            mf.setMfSortBy(2);
            mf.addOption(moRepository.findByMoCode("F6"));
            mf.addOption(moRepository.findByMoCode("O5"));
            mf.addOption(moRepository.findByMoCode("O2"));
            mf.addOption(moRepository.findByMoCode("O3"));

            mf.setMfStatus(sh.setItemStatus(Status.ACTIVE));
            mfRepository.save(mf);
            evtService.insertEvent("04695798", EventsHandled.CREATED, mf.toJson());


            mf = new MenuFunction();
            mf.setMfGroup(mg);
            mf.setMfCode("Z3");
            mf.setMfLabel("Menu Functions");
            mf.setMfRoute("/route_Z3");

            mf.setMfSortBy(3);
            mf.setMfStatus(sh.setItemStatus(Status.ACTIVE));
            mf.addOption(moRepository.findByMoCode("O3"));
            mf.addOption(moRepository.findByMoCode("O6"));
            mf.addOption(moRepository.findByMoCode("O7"));

            mfRepository.save(mf);
            evtService.insertEvent("04695798", EventsHandled.CREATED, ma.toJson());

            mf = new MenuFunction();
            mf.setMfGroup(mg);
            mf.setMfCode("Z4");
            mf.setMfLabel("Menu Options");
            mf.setMfRoute("/route_Z4");
            mf.setMfSortBy(4);
            mf.setMfStatus(sh.setItemStatus(Status.ACTIVE));
            mfRepository.save(mf);
            evtService.insertEvent("04695798", EventsHandled.CREATED, ma.toJson());

            mg = new MenuGroup();
            mg.setMenuApp(ma);
            mg.setMgCode("W");
            mg.setMgLabel("Work with Status");
            mg.setMgRoute("/route_W");
            mg.setMgSortBy(Integer.MAX_VALUE);
            mg.setMgStatus(sh.setItemStatus(Status.ACTIVE));
            mgRepository.save(mg);
            evtService.insertEvent("04695798", EventsHandled.CREATED, mg.toJson());

            mf = new MenuFunction();
            mf.setMfGroup(mg);
            mf.setMfCode("W1");
            mf.setMfLabel("Status Codes");
            mf.setMfRoute("/route_W1");
            mf.setMfSortBy(1);
            mf.setMfStatus(sh.setItemStatus(Status.ACTIVE));
            mfRepository.save(mf);
            evtService.insertEvent("04695798", EventsHandled.CREATED, ma.toJson());



            mf = new MenuFunction();
            mf.setMfGroup(mg);
            mf.setMfCode("W2");
            mf.setMfLabel("Status Sub-Codes");
            mf.setMfRoute("/route_W2");
            mf.setMfSortBy(1);
            mf.setMfStatus(sh.setItemStatus(Status.ACTIVE));
            mfRepository.save(mf);
            evtService.insertEvent("04695798", EventsHandled.CREATED, ma.toJson());
        }


    }
}
