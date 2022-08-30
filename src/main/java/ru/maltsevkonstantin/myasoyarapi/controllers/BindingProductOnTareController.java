package ru.maltsevkonstantin.myasoyarapi.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maltsevkonstantin.myasoyarapi.dto.BundleOfProductAndTareDto;
import ru.maltsevkonstantin.myasoyarapi.dto.SuccessResponse;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTare;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareItem;
import ru.maltsevkonstantin.myasoyarapi.services.BundleOfProductAndTareService;

@RestController
@RequestMapping("/binding_product_on_tare")
public class BindingProductOnTareController {

    private final BundleOfProductAndTareService service;
    private final ModelMapper mapper;

    @Autowired
    public BindingProductOnTareController(BundleOfProductAndTareService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> save(@RequestBody() BundleOfProductAndTareDto bundleOfProductAndTareDto) {
        BundleOfProductAndTare bundle = convertToBundleOfProductAndTare(bundleOfProductAndTareDto);
        for (BundleOfProductAndTareItem item : bundle.getItemList()) {
            item.setBundleOfProductAndTare(bundle);
        }
        service.save(bundle);
        return new ResponseEntity<>(new SuccessResponse("Сохранено"), HttpStatus.OK);
    }

    public BundleOfProductAndTare convertToBundleOfProductAndTare(BundleOfProductAndTareDto bundleOfProductAndTareDto) {
        return mapper.map(bundleOfProductAndTareDto, BundleOfProductAndTare.class);
    }
}
