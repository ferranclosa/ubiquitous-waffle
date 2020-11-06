package com.closa.data.dto;

import com.closa.data.model.MenuFunction;
import com.closa.global.dto.GlobaloDTO;

import java.util.ArrayList;
import java.util.List;

public class SMNU07oDTO extends GlobaloDTO {
List<MenuFunction> listOfMenuFunctions = new ArrayList<>();

    public SMNU07oDTO() {
    }

    public List<MenuFunction> getListOfMenuFunctions() {
        return listOfMenuFunctions;
    }

    public void setListOfMenuFunctions(List<MenuFunction> listOfMenuFunctions) {
        this.listOfMenuFunctions = listOfMenuFunctions;
    }
}
