package ru.maltsevkonstantin.myasoyarapi.models.documents;

import ru.maltsevkonstantin.myasoyarapi.models.libraries.Cell;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Tare;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bundle_of_product_and_tare")
public class BundleOfProductAndTare {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name = "production_plan_id", referencedColumnName = "id")
    ProductionPlan plan;
    @ManyToOne
    @JoinColumn(name = "tare_id", referencedColumnName = "id")
    Tare tare;
    @ManyToOne
    @JoinColumn(name = "cell_id", referencedColumnName = "id")
    Cell cell;
    @Enumerated(value = EnumType.STRING)
    BundleOfProductAndTareStatus status;

    @OneToMany(mappedBy = "bundleOfProductAndTare", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<BundleOfProductAndTareItem> itemList;

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

    public Tare getTare() {
        return tare;
    }

    public void setTare(Tare tare) {
        this.tare = tare;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public BundleOfProductAndTareStatus getStatus() {
        return status;
    }

    public void setStatus(BundleOfProductAndTareStatus status) {
        this.status = status;
    }

    public List<BundleOfProductAndTareItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<BundleOfProductAndTareItem> itemList) {
        this.itemList = itemList;
    }
}
