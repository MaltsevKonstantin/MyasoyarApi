package ru.maltsevkonstantin.myasoyarapi.models.documents;

import ru.maltsevkonstantin.myasoyarapi.models.libraries.Product;

import javax.persistence.*;

@Entity
@Table(name = "production_plan_item")
public class ProductionPlanItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "production_plan_id", referencedColumnName = "id")
    ProductionPlan plan;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product;

    @Column(name = "weight")
    float weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductionPlan getPlan() {
        return plan;
    }

    public void setPlan(ProductionPlan plan) {
        this.plan = plan;
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
}
