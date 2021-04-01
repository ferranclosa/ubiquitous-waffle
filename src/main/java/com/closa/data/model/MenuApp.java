package com.closa.data.model;

import com.closa.global.model.EntityCommon;
import com.closa.global.status.model.ItemStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="data_menu_app", indexes = {@Index(name = "UQ_ByApplication", unique = true, columnList = "ma_app")})
public class MenuApp implements EntityCommon {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "APPID")
    @TableGenerator(name="APPID",
            table="GEN_ID",
            pkColumnName = "key_name",
            valueColumnName = "key_val",
            pkColumnValue = "APP_ID",
            initialValue = 0,
            allocationSize = 10
            )
    @Column(name= "ma_id")
    private Long id;

    @Column(name="ma_app", length = 30, nullable = false)
    private String maApplication;
    @Column(name="ma_secured")
    private Boolean maIsAccessSecured;
    @OneToMany(mappedBy = "menuApp",
            cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MenuGroup> maGroups = new ArrayList<MenuGroup>();

    @Embedded
    private ItemStatus maStatus;

    public MenuApp() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaApplication() {
        return maApplication;
    }

    public void setMaApplication(String maApplication) {
        this.maApplication = maApplication;
    }

    public Boolean getMaIsAccessSecured() {
        return maIsAccessSecured;
    }

    public void setMaIsAccessSecured(Boolean maIsAccessSecured) {
        this.maIsAccessSecured = maIsAccessSecured;
    }

    public ItemStatus getMaStatus() {
        return maStatus;
    }

    public List<MenuGroup> getMaGroups() {
        return maGroups;
    }

    public void setMaGroups(List<MenuGroup> maGroups) {
        this.maGroups = maGroups;
    }

    public void setMaStatus(ItemStatus maStatus) {
        this.maStatus = maStatus;
    }
}
