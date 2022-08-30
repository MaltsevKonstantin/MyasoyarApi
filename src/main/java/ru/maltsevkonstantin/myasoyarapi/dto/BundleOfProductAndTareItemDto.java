package ru.maltsevkonstantin.myasoyarapi.dto;

import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareItemStatus;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Product;

public class BundleOfProductAndTareItemDto {
    int id;
    Product product;
    float weight;
    BundleOfProductAndTareItemStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public BundleOfProductAndTareItemStatus getStatus() {
        return status;
    }

    public void setStatus(BundleOfProductAndTareItemStatus status) {
        this.status = status;
    }
}
