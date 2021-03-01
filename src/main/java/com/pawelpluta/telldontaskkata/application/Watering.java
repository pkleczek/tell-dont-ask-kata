package com.pawelpluta.telldontaskkata.application;

import java.util.Optional;

import com.pawelpluta.telldontaskkata.domain.RaisedBed;
import com.pawelpluta.telldontaskkata.domain.WaterValve;
import com.pawelpluta.telldontaskkata.repository.RaisedBedRepository;
import com.pawelpluta.telldontaskkata.repository.WaterValveRepository;

public class Watering {

    private final RaisedBedRepository raisedBedRepository;
    private final WaterValveRepository waterValveRepository;

    public Watering(RaisedBedRepository raisedBedRepository, WaterValveRepository waterValveRepository) {
        this.raisedBedRepository = raisedBedRepository;
        this.waterValveRepository = waterValveRepository;
    }

    public boolean perform(WateringCommand command) {
        Optional<RaisedBed> raisedBed = raisedBedRepository.findById(command.getRaisedBedId());
        Optional<WaterValve> waterValve = waterValveRepository.findById(command.getValveId());
        if (waterValve.isEmpty()) {
            return false;
        }
        WaterValve valve = waterValve.get();
        return raisedBed.map(bed -> {
            boolean successfullyWatered = bed.water(valve);
            raisedBedRepository.save(bed);
            waterValveRepository.save(valve);
            return successfullyWatered;
        }).orElse(false);
    }

}
