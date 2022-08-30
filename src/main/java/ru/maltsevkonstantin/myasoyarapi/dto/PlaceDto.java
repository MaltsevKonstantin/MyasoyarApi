package ru.maltsevkonstantin.myasoyarapi.dto;

import java.util.List;

public class PlaceDto {
    int id;
    String name;
    List<CellDto> cells;

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

    public List<CellDto> getCells() {
        return cells;
    }

    public void setCells(List<CellDto> cells) {
        this.cells = cells;
    }
}
