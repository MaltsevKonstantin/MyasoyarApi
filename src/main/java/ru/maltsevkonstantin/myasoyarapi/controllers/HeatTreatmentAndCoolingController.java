package ru.maltsevkonstantin.myasoyarapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maltsevkonstantin.myasoyarapi.dto.HeatTreatmentDto;
import ru.maltsevkonstantin.myasoyarapi.dto.PlaceDto;
import ru.maltsevkonstantin.myasoyarapi.dto.SuccessResponse;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTare;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareItem;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareStatus;
import ru.maltsevkonstantin.myasoyarapi.models.documents.HeatTreatment;
import ru.maltsevkonstantin.myasoyarapi.services.BundleOfProductAndTareService;
import ru.maltsevkonstantin.myasoyarapi.services.HeatTreatmentAndCoolingService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/heat_treatment")
@Deprecated
public class HeatTreatmentAndCoolingController {

    private final HeatTreatmentAndCoolingService service;
    private final BundleOfProductAndTareService bundleService;
    private final ModelMapper mapper;

    @Autowired
    public HeatTreatmentAndCoolingController(HeatTreatmentAndCoolingService service, BundleOfProductAndTareService bundleService, ModelMapper mapper) {
        this.service = service;
        this.bundleService = bundleService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> saveHeatTreatment(@RequestBody() HeatTreatmentDto heatTreatmentDto) {
        HeatTreatment heatTreatment = convertToHeatTreatment(heatTreatmentDto);
        heatTreatment.setStartDate(new Date());
        service.saveHeatTreatment(heatTreatment);
        BundleOfProductAndTare bundle = heatTreatment.getBundle();
        for (BundleOfProductAndTareItem item: bundle.getItemList()) {
            item.setBundleOfProductAndTare(bundle);
        }
        bundleService.save(bundle);
        return new ResponseEntity<>(new SuccessResponse("Сохранено"), HttpStatus.OK);
    }

    @GetMapping
    public List<HeatTreatmentDto> heatTreatmentDtoList() {
        List<HeatTreatment> heatTreatmentList = service.findAllHeatTreatmentByBundleStatus(BundleOfProductAndTareStatus.COOKING);
        List<HeatTreatmentDto> heatTreatmentDtoList = new ArrayList<>();
        for (HeatTreatment heatTreatment: heatTreatmentList) {
            HeatTreatmentDto heatTreatmentDto = convertToHeatTreatmentDto(heatTreatment);
            heatTreatmentDto.setPlaceDto(mapper.map(heatTreatment.getBundle().getCell().getPlace(), PlaceDto.class));
            heatTreatmentDtoList.add(heatTreatmentDto);
        }
        return heatTreatmentDtoList;
    }

    private HeatTreatment convertToHeatTreatment(HeatTreatmentDto heatTreatmentDto) {
        return mapper.map(heatTreatmentDto, HeatTreatment.class);
    }

    private HeatTreatmentDto convertToHeatTreatmentDto(HeatTreatment heatTreatment) {
        return mapper.map(heatTreatment, HeatTreatmentDto.class);
    }
}
