package ru.maltsevkonstantin.myasoyarapi.models.documents;

public enum ProductionPlanStatus {
    WAITING("Ожидание"),
    WORKING("В работе"),
    COMPLETE("Завершен");

    private String displayed_name;

    ProductionPlanStatus(String displayed_name) {
        this.displayed_name = displayed_name;
    }

    public String getDisplayed_name() {
        return displayed_name;
    }
}
