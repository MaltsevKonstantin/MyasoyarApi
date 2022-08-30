package ru.maltsevkonstantin.myasoyarapi.dto;

import java.util.Calendar;

public class HeatTreatmentDto {
    int id;
    Calendar startCalendar;
    Calendar endCalendar;
    BundleOfProductAndTareDto bundle;
    UserDto user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getStartCalendar() {
        return startCalendar;
    }

    public void setStartCalendar(Calendar startCalendar) {
        this.startCalendar = startCalendar;
    }

    public Calendar getEndCalendar() {
        return endCalendar;
    }

    public void setEndCalendar(Calendar endCalendar) {
        this.endCalendar = endCalendar;
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
