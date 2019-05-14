package com.epam.util;

import com.epam.dao.BusDAO;
import com.epam.dao.BusDAOImpl;

public class Factory {
    private static BusDAO busDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public BusDAO getBusDAO(){
        if (busDAO == null){
            busDAO = new BusDAOImpl();
        }
        return busDAO;
    }
}
