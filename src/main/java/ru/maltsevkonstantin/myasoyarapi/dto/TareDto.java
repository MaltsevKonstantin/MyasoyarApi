package ru.maltsevkonstantin.myasoyarapi.dto;

import ru.maltsevkonstantin.myasoyarapi.models.libraries.TareType;

public class TareDto {
    int id;
    String name;
    float weight;
    TareType type;

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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public TareType getType() {
        return type;
    }

    public void setType(TareType type) {
        this.type = type;
    }
}
