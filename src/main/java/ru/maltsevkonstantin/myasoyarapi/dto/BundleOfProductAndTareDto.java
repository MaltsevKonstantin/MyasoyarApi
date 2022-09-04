package ru.maltsevkonstantin.myasoyarapi.dto;

import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareItem;
import ru.maltsevkonstantin.myasoyarapi.models.documents.BundleOfProductAndTareStatus;
import ru.maltsevkonstantin.myasoyarapi.models.documents.ProductionPlan;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Cell;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Tare;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class BundleOfProductAndTareDto {
    private int id;
    private ProductionPlanDto plan;
    private TareDto tare;
    private PlaceDto place;
    private CellDto cell;
    private BundleOfProductAndTareStatus status;
    private List<BundleOfProductAndTareItemDto> itemList;
    private Date bindingDate;
    private Date cookingStartDate;
    private Date coolingStartDate;
    private Date allowDroppingDate;
    private Date completeDate;

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

    public PlaceDto getPlace() {
        return place;
    }

    public void setPlace(PlaceDto place) {
        this.place = place;
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
}
