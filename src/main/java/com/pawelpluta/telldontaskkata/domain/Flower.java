package com.pawelpluta.telldontaskkata.domain;

public class Flower extends Plant {
    public Flower(Integer soilMoisturePercentage, Integer wateringCount) {
        super(soilMoisturePercentage, wateringCount);
    }

    @Override
    public boolean needsWatering() {
        return getSoilMoisturePercentage() < 50;
    }
}
