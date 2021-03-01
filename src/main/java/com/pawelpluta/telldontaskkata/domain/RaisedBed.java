package com.pawelpluta.telldontaskkata.domain;

import java.util.List;

public class RaisedBed {

    private Integer id;
    private List<Plant> plants;

    public RaisedBed(Integer id, List<Plant> plants) {
        this.id = id;
        this.plants = plants;
    }

    public Integer getId() {
        return id;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public boolean water(WaterValve waterValve) {
        for (Plant plant : plants) {
            Integer moisture = plant.getSoilMoisturePercentage();
            if (plant.needsWatering()) {
                try {
                    waterValve.setOpen(true);
                    Thread.sleep(100); // wait for some water to flow
                } catch (InterruptedException e) {
                    return false;
                } finally {
                    waterValve.setOpen(false);
                }
                plant.setSoilMoisturePercentage(moisture + 20);
                plant.setWateringCount(plant.getWateringCount() + 1);
            }
        }
        return true;
    }
}
