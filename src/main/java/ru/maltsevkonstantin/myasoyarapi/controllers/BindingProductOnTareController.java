package ru.maltsevkonstantin.myasoyarapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maltsevkonstantin.myasoyarapi.dto.*;
import ru.maltsevkonstantin.myasoyarapi.exceptions.NotFoundException;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTare;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareItem;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareStatus;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.CellAssignment;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Place;
import ru.maltsevkonstantin.myasoyarapi.services.BundleOfProductAndTareService;
import ru.maltsevkonstantin.myasoyarapi.services.PlaceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/binding_product_on_tare")
public class BindingProductOnTareController {

    private final BundleOfProductAndTareService bundleService;
    private final PlaceService placeService;
    private final ModelMapper mapper;

    @Autowired
    public BindingProductOnTareController(BundleOfProductAndTareService bundleService, PlaceService placeService, ModelMapper mapper) {
        this.bundleService = bundleService;
        this.placeService = placeService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<BundleOfProductAndTareDto> bundleList(@RequestParam(value = "status", defaultValue = "") BundleOfProductAndTareStatus status) {
        List<BundleOfProductAndTare> bundleList;
        try {
            bundleList = bundleService.findByStatus(status);
        } catch (Exception e) {
            bundleList = bundleService.findAll();
        }
        List<BundleOfProductAndTareDto> bundleDtoList = new ArrayList<>();
        for (BundleOfProductAndTare bundle : bundleList) {
            BundleOfProductAndTareDto bundleDto = convertToBundleOfProductAndTareDto(bundle);
            if (bundle.getCell() != null) bundleDto.setPlace(mapper.map(bundle.getCell().getPlace(), PlaceDto.class));
            bundleDtoList.add(bundleDto);
        }
        return bundleDtoList;
    }

    @GetMapping("/{id}")
    @Deprecated
    public BundleAndPlacesHolder bundleByTareId(@PathVariable int id,
                                                @RequestParam(value = "status", defaultValue = "null") BundleOfProductAndTareStatus status,
                                                @RequestParam(value = "cellAssignment", defaultValue = "null") CellAssignment cellAssignment) {
        try {
            BundleAndPlacesHolder holder = new BundleAndPlacesHolder();
            BundleOfProductAndTare bundle = bundleService.findByTareId(id);
            if (status != null) {
                if (bundle.getStatus() != status) throw new NotFoundException("Не найдено");
            }
            holder.setBundle(convertToBundleOfProductAndTareDto(bundle));
            List<Place> placeList = placeService.findAllFilterByCellAssigment(cellAssignment);
            holder.setPlaceDtoList(placeList.stream().map(this::convertToPlaceDto).collect(Collectors.toList()));
            return holder;
        } catch (Exception e) {
            throw new NotFoundException("Не найдено");
        }
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> save(@RequestBody() BundleOfProductAndTareDto bundleOfProductAndTareDto) {
        BundleOfProductAndTare bundle = convertToBundleOfProductAndTare(bundleOfProductAndTareDto);
        Optional<BundleOfProductAndTare> optBundle = bundleService.findById(bundle.getId());
        if (optBundle.isPresent() && optBundle.get().getStatus() != bundle.getStatus()) {
            if (bundle.getStatus() == BundleOfProductAndTareStatus.COOKING) bundle.setCookingStartDate(new Date());
            if (bundle.getStatus() == BundleOfProductAndTareStatus.COOLING) bundle.setCoolingStartDate(new Date());
            if (bundle.getStatus() == BundleOfProductAndTareStatus.ALLOW_DROPPING) bundle.setAllowDroppingDate(new Date());
            if (bundle.getStatus() == BundleOfProductAndTareStatus.COMPLETE) bundle.setCompleteDate(new Date());
        } else {
            bundle.setBindingDate(new Date());
        }
        for (BundleOfProductAndTareItem item : bundle.getItemList()) {
            item.setBundleOfProductAndTare(bundle);
        }
        bundleService.save(bundle);
        return new ResponseEntity<>(new SuccessResponse("Сохранено"), HttpStatus.OK);
    }

    private BundleOfProductAndTare convertToBundleOfProductAndTare(BundleOfProductAndTareDto bundleOfProductAndTareDto) {
        return mapper.map(bundleOfProductAndTareDto, BundleOfProductAndTare.class);
    }

    private BundleOfProductAndTareDto convertToBundleOfProductAndTareDto(BundleOfProductAndTare bundleOfProductAndTare) {
        return mapper.map(bundleOfProductAndTare, BundleOfProductAndTareDto.class);
    }

    private PlaceDto convertToPlaceDto(Place place) {
        return mapper.map(place, PlaceDto.class);
    }

    @ExceptionHandler()
    public ResponseEntity<ErrorResponse> notFoundException(NotFoundException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
