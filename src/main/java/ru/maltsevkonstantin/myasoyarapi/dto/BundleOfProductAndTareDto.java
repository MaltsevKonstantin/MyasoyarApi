package ru.maltsevkonstantin.myasoyarapi.dto;

import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareItem;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareStatus;
import ru.maltsevkonstantin.myasoyarapi.models.documents.ProductionPlan;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Cell;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Tare;

import javax.persistence.*;
import java.util.List;

public class BundleOfProductAndTareDto {
    int id;
    ProductionPlanDto plan;
    TareDto tare;
    CellDto cell;
    BundleOfProductAndTareStatus status;
    List<BundleOfProductAndTareItemDto> itemList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductionPlanDto getPlan() {
        return plan;
    }

    public void setPlan(ProductionPlanDto plan) {
        this.plan = plan;
    }

    public TareDto getTare() {
        return tare;
    }

    public void setTare(TareDto tare) {
        this.tare = tare;
    }

    public CellDto getCell() {
        return cell;
    }

    public void setCell(CellDto cell) {
        this.cell = cell;
    }

    public BundleOfProductAndTareStatus getStatus() {
        return status;
    }

    public void setStatus(BundleOfProductAndTareStatus status) {
        this.status = status;
    }

    public List<BundleOfProductAndTareItemDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<BundleOfProductAndTareItemDto> itemList) {
        this.itemList = itemList;
    }
}
