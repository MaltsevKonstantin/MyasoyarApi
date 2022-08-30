package ru.maltsevkonstantin.myasoyarapi.dto;

import ru.maltsevkonstantin.myasoyarapi.models.documents.ProductionPlanStatus;

import java.util.Date;
import java.util.List;

public class ProductionPlanDto {
    int id;
    Date date;
    String comment;
    ProductionPlanStatus status;
    private List<ProductionPlanItemDto> itemList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ProductionPlanStatus getStatus() {
        return status;
    }

    public void setStatus(ProductionPlanStatus status) {
        this.status = status;
    }

    public List<ProductionPlanItemDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<ProductionPlanItemDto> itemList) {
        this.itemList = itemList;
    }
}
