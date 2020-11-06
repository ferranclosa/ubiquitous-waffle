package com.closa.data.dto;

import com.closa.global.model.EntityCommon;

public class SMNU03iDTO implements EntityCommon {
    private String mgCode;
    private String mgRoute;
    private String mgLabel;
    private String mgDescription;
    private String mgStatus;
    private Integer mgSortBy;

    public SMNU03iDTO() {
    }

    public String getMgCode() {
        return mgCode;
    }

    public void setMgCode(String mgCode) {
        this.mgCode = mgCode;
    }

    public String getMgRoute() {
        return mgRoute;
    }

    public void setMgRoute(String mgRoute) {
        this.mgRoute = mgRoute;
    }

    public String getMgLabel() {
        return mgLabel;
    }

    public void setMgLabel(String mgLabel) {
        this.mgLabel = mgLabel;
    }

    public String getMgDescription() {
        return mgDescription;
    }

    public void setMgDescription(String mgDescription) {
        this.mgDescription = mgDescription;
    }

    public String getMgStatus() {
        return mgStatus;
    }

    public void setMgStatus(String mgStatus) {
        this.mgStatus = mgStatus;
    }

    public Integer getMgSortBy() {
        return mgSortBy;
    }

    public void setMgSortBy(Integer mgSortBy) {
        this.mgSortBy = mgSortBy;
    }
}
