package com.closa.data.service;

import com.closa.data.dao.maRepository;
import com.closa.data.dao.mfRepository;
import com.closa.data.dao.mgRepository;
import com.closa.data.model.MenuApp;
import com.closa.data.model.MenuFunction;
import com.closa.data.model.MenuGroup;
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
    mfRepository mfRepository;
    @Autowired
    EventService evtService;

    @Override
    public void run(String... args) throws Exception {

        if (maRepository.count() == 0) {
            MenuApp ma = new MenuApp();
            ma.setMaApplication("core");
            ma.setMaIsAccessSecured(false);
            ma.setMaStatus(sh.setItemStatus(Status.ACTIVE));
            maRepository.save(ma);
            evtService.insertEvent("04695798", EventsHandled.CREATED, ma.toJson());

            MenuGroup mg = new MenuGroup();
            mg.setMenuApp(ma);
            mg.setMgCode("Z");
            mg.setMgLabel("Settings");
            mg.setMgRoute("/route_Z");
            mg.setMgSortBy(Integer.MAX_VALUE);
            mg.setMgStatus(sh.setItemStatus(Status.ACTIVE));
            mgRepository.save(mg);
            evtService.insertEvent("04695798", EventsHandled.CREATED, mg.toJson());


            MenuFunction mf = new MenuFunction();
            mf.setMfGroup(mg);
            mf.setMfCode("Z1");
            mf.setMfRoute("/route_Z1");
            mf.setMfLabel("Work with Users");
            mf.setMfSortBy(1);
            mf.setMfStatus(sh.setItemStatus(Status.ACTIVE));
            mfRepository.save(mf);
            evtService.insertEvent("04695798", EventsHandled.CREATED, mf.toJson());


            mf = new MenuFunction();
            mf.setMfGroup(mg);
            mf.setMfCode("Z2");
            mf.setMfLabel("Work with Menus");
            mf.setMfRoute("/route_Z2");
            mf.setMfSortBy(2);
            mf.setMfStatus(sh.setItemStatus(Status.ACTIVE));
            mfRepository.save(mf);
            evtService.insertEvent("04695798", EventsHandled.CREATED, mf.toJson());


            mf = new MenuFunction();
            mf.setMfGroup(mg);
            mf.setMfCode("Z3");
            mf.setMfLabel("Work with Status");
            mf.setMfRoute("/route_Z3");
            mf.setMfSortBy(3);
            mf.setMfStatus(sh.setItemStatus(Status.ACTIVE));
            mfRepository.save(mf);
            evtService.insertEvent("04695798", EventsHandled.CREATED, ma.toJson());
        }

    }
}
