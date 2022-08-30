package ru.maltsevkonstantin.myasoyarapi.dto;

import ru.maltsevkonstantin.myasoyarapi.models.libraries.Product;

import java.util.List;

public class ProductionPlanHolderDto {
    private ProductionPlanDto productionPlanDto;
    private List<Product> productList;

    public ProductionPlanDto getProductionPlanDto() {
        return productionPlanDto;
    }

    public void setProductionPlanDto(ProductionPlanDto productionPlanDto) {
        this.productionPlanDto = productionPlanDto;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
