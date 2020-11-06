package com.closa.data.dto;

import com.closa.data.model.MenuFunction;
import com.closa.global.dto.GlobaloDTO;

import java.util.ArrayList;
import java.util.List;

public class SMNU04oDTO extends GlobaloDTO {
    private List<MenuFunction> listOfGroupFunctions = new ArrayList<>();

    public SMNU04oDTO() {
    }

    public List<MenuFunction> getListOfGroupFunctions() {
        return listOfGroupFunctions;
    }

    public void setListOfGroupFunctions(List<MenuFunction> listOfGroupFunctions) {
        this.listOfGroupFunctions = listOfGroupFunctions;
    }
}
