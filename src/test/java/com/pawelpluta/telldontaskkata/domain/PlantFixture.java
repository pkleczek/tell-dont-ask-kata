package com.pawelpluta.telldontaskkata.domain;

public class PlantFixture {

    public static Plant somePlant() {
        return new Flower(30, 0);
    }

    public static Plant plantWithMoistureOf(Integer soilMoisture) {
        return new Flower(soilMoisture, 0);
    }

    public static Plant plantWithWateringCountOf(Integer wateringCount) {
        return new Flower(50, wateringCount);
    }
}
