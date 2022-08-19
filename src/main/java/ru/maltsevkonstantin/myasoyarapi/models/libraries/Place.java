package ru.maltsevkonstantin.myasoyarapi.models.libraries;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Place")
public class Place {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "place", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Cell> cells;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
