package ru.maltsevkonstantin.myasoyarapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.maltsevkonstantin.myasoyarapi.services.HeatTreatmentAndCoolingService;

@RestController
public class HeatTreatmentAndCoolingController {

    private final HeatTreatmentAndCoolingService service;
    private final ModelMapper mapper;

    @Autowired
    public HeatTreatmentAndCoolingController(HeatTreatmentAndCoolingService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


}
