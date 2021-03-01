package com.pawelpluta.telldontaskkata.domain;

public abstract class Plant {

    protected Integer soilMoisturePercentage;
    protected Integer wateringCount;

    public Plant(Integer soilMoisturePercentage, Integer wateringCount) {
        this.soilMoisturePercentage = soilMoisturePercentage;
        this.wateringCount = wateringCount;
    }

    public Integer getSoilMoisturePercentage() {
        return soilMoisturePercentage;
    }

    public void setSoilMoisturePercentage(Integer soilMoisturePercentage) {
        this.soilMoisturePercentage = soilMoisturePercentage;
    }

    public Integer getWateringCount() {
        return wateringCount;
    }

    public void setWateringCount(Integer wateringCount) {
        this.wateringCount = wateringCount;
    }

    public abstract boolean needsWatering();
}
