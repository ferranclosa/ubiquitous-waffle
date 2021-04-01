package com.closa.data.dto;

import com.closa.data.model.MenuApp;
import com.closa.data.model.MenuGroup;
import com.closa.global.dto.StandardQueryResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SMNU10oDTO extends StandardQueryResponse {
    public List<MenuApp> menuApps = new ArrayList<>();

    public SMNU10oDTO() {
    }

    public List<MenuApp> getMenuApps() {
        return menuApps;
    }

    public void setMenuApps(List<MenuApp> menuApps) {
        this.menuApps = menuApps;
    }
}
