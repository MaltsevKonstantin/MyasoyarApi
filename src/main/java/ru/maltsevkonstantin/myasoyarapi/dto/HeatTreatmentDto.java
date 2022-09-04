package ru.maltsevkonstantin.myasoyarapi.dto;

import org.springframework.format.annotation.DateTimeFormat;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Place;

import java.util.Calendar;
import java.util.Date;

public class HeatTreatmentDto {
    int id;
    Date startDate;
    Date endDate;

    PlaceDto placeDto;
    BundleOfProductAndTareDto bundle;
    UserDto user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlaceDto getPlaceDto() {
        return placeDto;
    }

    public void setPlaceDto(PlaceDto placeDto) {
        this.placeDto = placeDto;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BundleOfProductAndTareDto getBundle() {
        return bundle;
    }

    public void setBundle(BundleOfProductAndTareDto bundle) {
        this.bundle = bundle;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
