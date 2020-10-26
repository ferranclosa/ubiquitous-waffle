package com.closa.data.dto;

import com.closa.data.model.MenuGroup;
import com.closa.global.dto.StandardQueryResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SMNU01oDTO extends StandardQueryResponse {
    public List<MenuGroup> menuGroups = new ArrayList<>();

    public SMNU01oDTO() {
    }

    public List<MenuGroup> getMenuGroups() {
        return menuGroups;
    }

    public void setMenuGroups(List<MenuGroup> menuGroups) {
        this.menuGroups = menuGroups;
    }
}
