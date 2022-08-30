package ru.maltsevkonstantin.myasoyarapi.dto;

import ru.maltsevkonstantin.myasoyarapi.models.libraries.CellAssignment;

public class CellDto {
    private int id;
    private String name;
    private float capacity;

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

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }
}
