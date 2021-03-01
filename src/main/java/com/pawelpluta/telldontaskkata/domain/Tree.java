package com.pawelpluta.telldontaskkata.domain;

public class Tree extends Plant {
    public Tree(Integer soilMoisturePercentage, Integer wateringCount) {
        super(soilMoisturePercentage, wateringCount);
    }

    @Override
    public boolean needsWatering() {
        return getSoilMoisturePercentage() < 45;
    }
}
