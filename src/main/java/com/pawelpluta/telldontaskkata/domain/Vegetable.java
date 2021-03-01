package com.pawelpluta.telldontaskkata.domain;

public class Vegetable extends Plant {
    public Vegetable(Integer soilMoisturePercentage, Integer wateringCount) {
        super(soilMoisturePercentage, wateringCount);
    }

    @Override
    public boolean needsWatering() {
        return getSoilMoisturePercentage() < 60;
    }
}
