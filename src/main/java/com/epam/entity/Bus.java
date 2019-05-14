package com.epam.entity;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Component
public class Bus {
    private Long id;
    private String number = "72";
    private Set drivers = new HashSet<>();
    private Long route_id = 22L;

    public Bus()
    {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set getDrivers() {
        return drivers;
    }

    public void setDrivers(Set drivers) {
        this.drivers = drivers;
    }

    public Long getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Long route_id) {
        this.route_id = route_id;
    }
}
