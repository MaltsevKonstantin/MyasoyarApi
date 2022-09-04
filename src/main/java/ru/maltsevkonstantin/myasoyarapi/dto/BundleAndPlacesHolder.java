package ru.maltsevkonstantin.myasoyarapi.dto;

import java.util.List;

public class BundleAndPlacesHolder {
    private BundleOfProductAndTareDto bundle;
    private List<PlaceDto> placeDtoList;

    public BundleOfProductAndTareDto getBundle() {
        return bundle;
    }

    public void setBundle(BundleOfProductAndTareDto bundle) {
        this.bundle = bundle;
    }

    public List<PlaceDto> getPlaceDtoList() {
        return placeDtoList;
    }

    public void setPlaceDtoList(List<PlaceDto> placeDtoList) {
        this.placeDtoList = placeDtoList;
    }
}
