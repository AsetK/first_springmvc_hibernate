package com.epam.dao;

import com.epam.entity.Bus;

import java.sql.SQLException;
import java.util.Collection;

public interface BusDAO {
    public void addBus(Bus bus) throws SQLException;
    public void persistBus(Bus bus) throws SQLException;
    public void updateBus(Bus bus) throws SQLException;
    public Bus getBusById(Long bus_id) throws SQLException;
    public Collection getAllBusses() throws SQLException;
    public void deleteBus( Bus bus) throws SQLException;
    public void mergeBus(Bus bus) throws SQLException;
    public void replicateBus(Bus bus) throws SQLException;

}
