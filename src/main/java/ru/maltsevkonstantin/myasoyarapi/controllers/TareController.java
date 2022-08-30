package ru.maltsevkonstantin.myasoyarapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maltsevkonstantin.myasoyarapi.dto.TareDto;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Tare;
import ru.maltsevkonstantin.myasoyarapi.services.TaresService;

import java.util.Date;

@RestController
@RequestMapping("/tares")
public class TareController {

    private final ModelMapper mapper;

    private final TaresService service;

    @Autowired
    public TareController(ModelMapper mapper, TaresService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping("/{id}")
    public TareDto tareById(@PathVariable int id) {
        Tare tare = service.findByIdAndWeightDateLessThanCurrent(id);
        TareDto tareDto = convertToTareDto(tare);
        if (tare.getWeights().isEmpty()) tareDto.setWeight(0);
        else {
            Date maxDate = tare.getWeights().get(0).getDate();
            tareDto.setWeight(tare.getWeights().get(0).getWeight());
            for (Tare.Weight weight : tare.getWeights()) {
                if (weight.getDate().getTime() > maxDate.getTime()) {
                    maxDate = weight.getDate();
                    tareDto.setWeight(weight.getWeight());
                }
            }
        }
        return tareDto;
    }

    private TareDto convertToTareDto(Tare tare) {
        return mapper.map(tare, TareDto.class);
    }
}
