package ru.maltsevkonstantin.myasoyarapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maltsevkonstantin.myasoyarapi.dto.ErrorResponse;
import ru.maltsevkonstantin.myasoyarapi.dto.PlaceDto;
import ru.maltsevkonstantin.myasoyarapi.dto.SuccessResponse;
import ru.maltsevkonstantin.myasoyarapi.exceptions.NameExistsException;
import ru.maltsevkonstantin.myasoyarapi.exceptions.NotFoundException;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.CellAssignment;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Place;
import ru.maltsevkonstantin.myasoyarapi.services.PlaceService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;
    private final ModelMapper mapper;

    @Autowired
    public PlaceController(PlaceService placeService, ModelMapper mapper) {
        this.placeService = placeService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PlaceDto> places(@RequestParam(value = "assignment", defaultValue = "") CellAssignment assignment) {
        List<Place> placeList;
        try {
            if (assignment == null) placeList = placeService.findAll();
            else placeList = placeService.findByCellsAssignmentOrderByName(assignment);
        } catch (Exception e) {
            placeList = placeService.findAll();
        }
        return placeList.stream().map(this::convertToPlaceDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PlaceDto place(@PathVariable int id) {
        return convertToPlaceDto(placeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> save(@RequestBody PlaceDto placeDto) {
        Optional<Place> optPlace = placeService.findByName(placeDto.getName());
        if (optPlace.isPresent() && optPlace.get().getId() != placeDto.getId()) throw new NameExistsException("Имя занято");
        placeService.save(convertToPlace(placeDto));
        return new ResponseEntity<>(new SuccessResponse("Сохранено"), HttpStatus.OK);
    }

    private PlaceDto convertToPlaceDto(Place place) {
        return mapper.map(place, PlaceDto.class);
    }

    private Place convertToPlace(PlaceDto placeDto) {
        return mapper.map(placeDto, Place.class);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> notFoundException(NotFoundException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> nameExistsException(NameExistsException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.CONFLICT);
    }
}
