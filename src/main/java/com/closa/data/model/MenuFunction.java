package com.closa.data.model;

import com.closa.global.model.EntityCommon;
import com.closa.global.status.model.ItemStatus;
import com.closa.global.status.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "data_menu_functions" , indexes = {@Index(name = "UQ_ByCode", unique = true, columnList = "mf_code")})
public class MenuFunction implements EntityCommon {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "FNCID")
    @TableGenerator(name="FNCID",
            table="GEN_ID",
            pkColumnName = "key_name",
            valueColumnName = "key_val",
            pkColumnValue = "FNC_ID",
            initialValue = 0,
            allocationSize = 10
    )
    @Column(name="mf_id")
    private Long id;
    @ManyToOne (fetch = FetchType.LAZY)
    @JsonIgnore
    private MenuGroup mfGroup;
    @Column(length = 5, nullable = false, name = "mf_code")
    private String mfCode;
    @Column(length = 20, nullable = false, name = "mf_label")
    private String mfLabel;
    @Column(length = 150, nullable = true, name = "mf_description")
    private String mfDescription;
    private Integer mfSortBy;
    @Transient
    private Boolean mfActive;
    @Column(length = 20, nullable = false, name = "mf_route")
    private String mfRoute;
    @Column(length = 5, nullable = true, name = "mf_level")
    private String mfAccessLevel;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(mappedBy = "moFunction",
            cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MenuOption> mfOptions = new ArrayList<MenuOption>();
    @Embedded
    private ItemStatus mfStatus;



    public MenuFunction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMfCode() {
        return mfCode;
    }

    public void setMfCode(String mfCode) {
        this.mfCode = mfCode;
    }

    public String getMfLabel() {
        return mfLabel;
    }

    public void setMfLabel(String mfLabel) {
        this.mfLabel = mfLabel;
    }

    public String getMfDescription() {
        return mfDescription;
    }

    public void setMfDescription(String mfDescription) {
        this.mfDescription = mfDescription;
    }

    public Integer getMfSortBy() {
        return mfSortBy;
    }

    public void setMfSortBy(Integer mfSortBy) {
        this.mfSortBy = mfSortBy;
    }

    public Boolean getMfActive() {
        if(this.mfStatus.getFullStatus().equalsIgnoreCase(String.valueOf(Status.ACTIVE.getValue()))){
            return true;
        } else
        return false;
    }

    public void setMfActive(Boolean mfActive) {
        this.mfActive = mfActive;
    }

    public String getMfRoute() {
        return mfRoute;
    }

    public void setMfRoute(String mfRoute) {
        this.mfRoute = mfRoute;
    }

    public String getMfAccessLevel() {
        return mfAccessLevel;
    }

    public void setMfAccessLevel(String mfAccessLevel) {
        this.mfAccessLevel = mfAccessLevel;
    }

    public List<MenuOption> getMfOptions() {
        return mfOptions;
    }

    public void setMfOptions(List<MenuOption> mfOptions) {
        this.mfOptions = mfOptions;
    }

    public ItemStatus getMfStatus() {
        return mfStatus;
    }

    public void setMfStatus(ItemStatus mfStatus) {
        this.mfStatus = mfStatus;
    }

    public MenuGroup getMfGroup() {
        return mfGroup;
    }

    public void setMfGroup(MenuGroup mfGroup) {
        this.mfGroup = mfGroup;
    }
}