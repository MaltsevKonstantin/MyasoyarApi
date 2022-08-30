package ru.maltsevkonstantin.myasoyarapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maltsevkonstantin.myasoyarapi.dto.*;
import ru.maltsevkonstantin.myasoyarapi.exceptions.NotFoundException;
import ru.maltsevkonstantin.myasoyarapi.models.documents.ProductionPlan;
import ru.maltsevkonstantin.myasoyarapi.models.documents.ProductionPlanStatus;
import ru.maltsevkonstantin.myasoyarapi.services.ProductService;
import ru.maltsevkonstantin.myasoyarapi.services.ProductionPlanService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/production_plans")
public class ProductionPlanController {

    private final ProductionPlanService productionPlanService;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductionPlanController(ProductionPlanService productionPlanService, ProductService productService, ModelMapper modelMapper) {
        this.productionPlanService = productionPlanService;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<ProductionPlanDto> productionPlanListByStatus(@RequestParam(value = "status", defaultValue = "") String status) {
        try {
            ProductionPlanStatus s = ProductionPlanStatus.valueOf(status);
            return productionPlanService.findByStatusOrderByDate(s).stream().map(this::convertToProductionPlanDto).collect(Collectors.toList());
        } catch (Exception e) {
            return productionPlanService.findAll().stream().map(this::convertToProductionPlanDto).collect(Collectors.toList());
        }
    }

    @GetMapping("/{id}")
    public ProductionPlanHolderDto productionPlan(@PathVariable int id) {
        ProductionPlanHolderDto holderDto = new ProductionPlanHolderDto();
        holderDto.setProductionPlanDto(convertToProductionPlanDto(productionPlanService.findById(id)));
        holderDto.setProductList(productService.findAll());
        return holderDto;
    }

    @GetMapping("/{id}/only")
    public ProductionPlanDto productionPlanOnly(@PathVariable int id) {
        return convertToProductionPlanDto(productionPlanService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> save(@RequestBody ProductionPlanDto productionPlanDto) {
        ProductionPlan productionPlan = convertToProductionPlan(productionPlanDto);
        productionPlanService.save(productionPlan);

        return new ResponseEntity<>(new SuccessResponse("Производственный план записан"), HttpStatus.OK);
    }

    private ProductionPlanDto convertToProductionPlanDto(ProductionPlan plan) {
        return modelMapper.map(plan, ProductionPlanDto.class);
    }

    private ProductionPlan convertToProductionPlan(ProductionPlanDto planDto) {
        return modelMapper.map(planDto, ProductionPlan.class);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> notFoundException(NotFoundException e) {
        ErrorResponse errorMessage = new ErrorResponse();
        errorMessage.setTimestamp(System.currentTimeMillis());
        errorMessage.setMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

}
