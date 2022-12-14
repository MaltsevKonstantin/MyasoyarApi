package ru.maltsevkonstantin.myasoyarapi.models.libraries;

import javax.persistence.*;

@Entity
@Table(name = "cells")
public class Cell {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place place;

    @Column(name = "capacity")
    private float capacity;

    @Enumerated(value = EnumType.STRING)
    private CellAssignment assignment;

    public CellAssignment getAssignment() {
        return assignment;
    }

    public void setAssignment(CellAssignment assignment) {
        this.assignment = assignment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }
}
