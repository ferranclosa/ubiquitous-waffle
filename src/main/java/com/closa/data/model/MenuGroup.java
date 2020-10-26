package com.closa.data.model;

import com.closa.global.model.EntityCommon;
import com.closa.global.status.model.ItemStatus;
import com.closa.global.status.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="data_menu_group", indexes = {@Index(name = "UQ_ByGroup", unique = true, columnList = "mg_code")})
public class MenuGroup implements EntityCommon {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "GRPID")
    @TableGenerator(name="GRPID",
            table="GEN_ID",
            pkColumnName = "key_name",
            valueColumnName = "key_val",
            pkColumnValue = "GRP_ID",
            initialValue = 0,
            allocationSize = 10
    )


    @Column(name="mg_id")
    private Long id;

    @ManyToOne
    @JsonIgnore
    private MenuApp menuApp;

    @Column(name="mg_code", nullable = false, unique = true, length = 5)
    private String mgCode;
    @Column(name="mg_label", nullable = false, unique = true, length = 20)
    private String mgLabel;
    @Column(name="mg_description", nullable = true, length = 150)
    private String mgDescription;
    private Integer mgSortBy;
    @Column(name="mg_route", nullable = false, unique = true, length = 20)
    private String mgRoute;
    @Transient
    private Boolean mgActive;

    private String mgAccessLevel;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(mappedBy = "mfGroup",
    cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MenuFunction> mgFunctions = new ArrayList<MenuFunction>();
    @Embedded
    private ItemStatus mgStatus;

    public MenuGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MenuApp getMenuApp() {
        return menuApp;
    }

    public void setMenuApp(MenuApp menuApp) {
        this.menuApp = menuApp;
    }

    public String getMgCode() {
        return mgCode;
    }

    public void setMgCode(String mgCode) {
        this.mgCode = mgCode;
    }

    public String getMgLabel() {
        return mgLabel;
    }

    public void setMgLabel(String mgLabel) {
        this.mgLabel = mgLabel;
    }

    public Integer getMgSortBy() {
        return mgSortBy;
    }

    public void setMgSortBy(Integer mgSortBy) {
        this.mgSortBy = mgSortBy;
    }

    public String getMgRoute() {
        return mgRoute;
    }

    public void setMgRoute(String mgRoute) {
        this.mgRoute = mgRoute;
    }

    public String getMgAccessLevel() {
        return mgAccessLevel;
    }

    public void setMgAccessLevel(String mgAccessLevel) {
        this.mgAccessLevel = mgAccessLevel;
    }

    public List<MenuFunction> getMgFunctions() {
        return mgFunctions;
    }

    public void setMgFunctions(List<MenuFunction> mgFunctions) {
        this.mgFunctions = mgFunctions;
    }

    public ItemStatus getMgStatus() {
        return mgStatus;
    }

    public void setMgStatus(ItemStatus mgStatus) {
        this.mgStatus = mgStatus;
    }

    public Boolean getMgActive() {
        if(this.mgStatus.getFullStatus().equalsIgnoreCase(String.valueOf(Status.ACTIVE.getValue()))){
            return true;
        } else
            return false;
    }
}
