package ru.maltsevkonstantin.myasoyarapi.models.libraries;

public enum TareType {
    MANUFACTURE("Производственная"),
    MANUFACTURE_RAW("Производственная (сырье)"),
    TRANSPORT("Транспортировочная (телеги)"),
    BOX("Транспортировочная");

    private String displayedName;

    TareType(String displayedName) {
        this.displayedName = displayedName;
    }

    public String getDisplayedName() {
        return displayedName;
    }
}
