package ru.maltsevkonstantin.myasoyarapi.models.documents;

import ru.maltsevkonstantin.myasoyarapi.models.libraries.Cell;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Tare;

import javax.persistence.*;
import java.util.Date;
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

    @Column(name = "binding_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bindingDate;
    @Column(name = "cooking_start_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date cookingStartDate;
    @Column(name = "cooling_start_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date coolingStartDate;
    @Column(name = "allow_dropping_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date allowDroppingDate;
    @Column(name = "complete_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date completeDate;

    public Date getBindingDate() {
        return bindingDate;
    }

    public void setBindingDate(Date bindingDate) {
        this.bindingDate = bindingDate;
    }

    public Date getCookingStartDate() {
        return cookingStartDate;
    }

    public void setCookingStartDate(Date cookingStartDate) {
        this.cookingStartDate = cookingStartDate;
    }

    public Date getCoolingStartDate() {
        return coolingStartDate;
    }

    public void setCoolingStartDate(Date coolingStartDate) {
        this.coolingStartDate = coolingStartDate;
    }

    public Date getAllowDroppingDate() {
        return allowDroppingDate;
    }

    public void setAllowDroppingDate(Date allowDroppingDate) {
        this.allowDroppingDate = allowDroppingDate;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

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
