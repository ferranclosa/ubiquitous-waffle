package com.closa.data.dto;

import com.closa.global.model.EntityCommon;
import com.closa.global.status.model.ItemStatus;

public class SMNU06iDTO implements EntityCommon {
    private Long id;
    private String mgCode;
    private String mgRoute;
    private String mgLabel;
    private String mgDescription;
    private ItemStatus mgStatus;
    private Integer mgSortBy;

    public SMNU06iDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ItemStatus getMgStatus() {
        return mgStatus;
    }

    public void setMgStatus(ItemStatus mgStatus) {
        this.mgStatus = mgStatus;
    }

    public Integer getMgSortBy() {
        return mgSortBy;
    }

    public void setMgSortBy(Integer mgSortBy) {
        this.mgSortBy = mgSortBy;
    }
}
