package com.closa.data.model;

import com.closa.global.status.model.ItemStatus;
import com.closa.global.status.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="data_menu_option", indexes = {@Index(name = "UQ_ByOption", unique = true, columnList = "mo_code")})

public class MenuOption {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "OPTID")
    @TableGenerator(name="OPTID",
            table="GEN_ID",
            pkColumnName = "key_name",
            valueColumnName = "key_val",
            pkColumnValue = "OPT_ID",
            initialValue = 0,
            allocationSize = 10
    )

    @Column(name="mo_id")
    private Long id;
    @ManyToOne
    @JsonIgnore
    private MenuFunction moFunction;

    @Column(name="mo_code")
    private String moCode;
    @Column(name="mo_label")
    private String moLabel;
    @Column(name="mo_description")
    private String moDescription;
    @Column(name="mo_sort_by")
    private Integer moSortBy;
    @Transient
    @Column(name="mo_active")
    private Boolean moActive;
    @Column(name="mo_route")
    private String moRoute;
    @Embedded
    private ItemStatus moStatus;

    public MenuOption() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoCode() {
        return moCode;
    }

    public void setMoCode(String moCode) {
        this.moCode = moCode;
    }

    public String getMoLabel() {
        return moLabel;
    }

    public void setMoLabel(String moLabel) {
        this.moLabel = moLabel;
    }

    public String getMoDescription() {
        return moDescription;
    }

    public void setMoDescription(String moDescription) {
        this.moDescription = moDescription;
    }

    public Integer getMoSortBy() {
        return moSortBy;
    }

    public void setMoSortBy(Integer moSortBy) {
        this.moSortBy = moSortBy;
    }

    public ItemStatus getMoStatus() {
        return moStatus;
    }

    public void setMoStatus(ItemStatus moStatus) {
        this.moStatus = moStatus;
    }

    public String getMoRoute() {
        return moRoute;
    }

    public void setMoRoute(String moRoute) {
        this.moRoute = moRoute;
    }

    public MenuFunction getMoFunction() {
        return moFunction;
    }

    public void setMoFunction(MenuFunction moFunction) {
        this.moFunction = moFunction;
    }

    public Boolean getMoActive() {
        if(this.moStatus.getFullStatus().equalsIgnoreCase(String.valueOf(Status.ACTIVE.getValue()))){
            return true;
        } else
            return false;
    }
}
