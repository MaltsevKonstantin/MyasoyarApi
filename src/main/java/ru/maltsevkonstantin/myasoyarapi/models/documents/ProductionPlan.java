package ru.maltsevkonstantin.myasoyarapi.models.documents;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "production_plan")
public class ProductionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    Date date;

    @Column(name = "comment")
    String comment;

    @Enumerated(EnumType.STRING)
    ProductionPlanStatus status;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductionPlanItem> itemList;

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

    public List<ProductionPlanItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<ProductionPlanItem> itemList) {
        this.itemList = itemList;
    }
}
