package ru.maltsevkonstantin.myasoyarapi.models.documents;

import ru.maltsevkonstantin.myasoyarapi.models.libraries.Product;

import javax.persistence.*;

@Entity
@Table(name = "bundle_of_product_and_tare_item")
public class BundleOfProductAndTareItem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name = "bundle_of_product_and_tare_id", referencedColumnName = "id")
    BundleOfProductAndTare bundleOfProductAndTare;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product;
    @Column(name = "weight")
    float weight;
    @Enumerated(value = EnumType.STRING)
    BundleOfProductAndTareItemStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BundleOfProductAndTare getBundleOfProductAndTare() {
        return bundleOfProductAndTare;
    }

    public void setBundleOfProductAndTare(BundleOfProductAndTare bundleOfProductAndTare) {
        this.bundleOfProductAndTare = bundleOfProductAndTare;
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
