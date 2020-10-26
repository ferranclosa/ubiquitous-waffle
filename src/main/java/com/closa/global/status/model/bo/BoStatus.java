package com.closa.global.status.model.bo;

import java.util.Objects;

public class BoStatus {
    private String compositeStatus;
    private String description;
    private String useCase;

    public BoStatus() {
    }

    public BoStatus(String compositeStatus, String description) {
        this.compositeStatus = compositeStatus;
        this.description = description;
    }

    public String getCompositeStatus() {
        return compositeStatus;
    }

    public void setCompositeStatus(String compositeStatus) {
        this.compositeStatus = compositeStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUseCase() {
        return useCase;
    }

    public void setUseCase(String useCase) {
        this.useCase = useCase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoStatus boStatus = (BoStatus) o;
        return Objects.equals(compositeStatus, boStatus.compositeStatus) &&
                Objects.equals(description, boStatus.description) &&
                Objects.equals(useCase, boStatus.useCase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compositeStatus, description, useCase);
    }
}
