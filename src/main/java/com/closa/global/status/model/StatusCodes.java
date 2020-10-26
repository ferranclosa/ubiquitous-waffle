package com.closa.global.status.model;

import com.closa.global.model.EntityCommon;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "parm_sts_code")
public class StatusCodes implements EntityCommon {

    @Id
    @Column(name="status_code", length = 1, nullable = false, unique = true, insertable = false, updatable = false)
    private String statusCode;

    @Column(name="status_description", length = 255, nullable = false)
    private String statusDescription;

    @Embedded
    private ItemStatus status;

    public StatusCodes()  {
    }

    public StatusCodes(String sc, String desc) {
        this.statusCode = sc;
        this.statusDescription = desc;

    }

    @Override
    public String toString() {
        return "StatusCodes{" +
                "statusCode='" + statusCode + '\'' +
                ", statusDescription='" + statusDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusCodes that = (StatusCodes) o;
        return Objects.equals(statusCode, that.statusCode) &&
                Objects.equals(statusDescription, that.statusDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, statusDescription);
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }
}
