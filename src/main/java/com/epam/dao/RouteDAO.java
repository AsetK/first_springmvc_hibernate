package com.epam.dao;


import com.epam.entity.Route;
import com.epam.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.sql.SQLException;

public class RouteDAO {

    public Route getRouteById(Long route_id) throws SQLException {
        Session session = null;
        Route route = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            route = session.get(Route.class, route_id);
            Hibernate.initialize(route.getBusses());
        }
        catch (Exception exc)
        {

        }
        finally
        {
            if(session!=null && session.isOpen())
                session.close();
        }
        return route;
    }
}
