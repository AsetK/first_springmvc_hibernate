package com.epam.dao;

import com.epam.entity.Bus;
import com.epam.util.HibernateUtil;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BusDAOImpl implements BusDAO{
    @Override
    public void addBus(Bus bus)  throws SQLException{
        Session session = null;
        Transaction tx = null;
        try
        {
            session = HibernateUtil.getSessionFactory().getCurrentSession();

            tx = session.beginTransaction();
            Long id = (Long)session.save(bus);
            tx.commit();
        }
        catch (Exception exc)
        {
            if(tx!=null)
                tx.rollback();
            throw exc;
        }
        finally
        {
            if(session!=null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void persistBus(Bus bus)  throws SQLException{
        Session session = null;
        Transaction tx = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();

            tx = session.beginTransaction();
            session.persist(bus);
            tx.commit();
        }
        catch (Exception exc)
        {
            if(tx!=null)
                tx.rollback();
            throw exc;
        }
        finally
        {
            if(session!=null && session.isOpen())
                session.close();
        }
    }



    @Override
    public void updateBus(Bus bus) throws SQLException {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(bus);
            session.getTransaction().commit();
        }
        catch (Exception exc)
        {

        }
        finally
        {
            if(session!=null && session.isOpen())
                session.close();
        }
    }

    @Override
    public Bus getBusById(Long bus_id) throws SQLException {
        Session session = null;
        Bus bus = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            bus = session.get(Bus.class, bus_id);
        }
        catch (Exception exc)
        {

        }
        finally
        {
            if(session!=null && session.isOpen())
                session.close();
        }
        return bus;
    }

    @Override
    public Collection getAllBusses() throws SQLException {
        Session session = null;
        List busses = new ArrayList<Bus>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            busses = session.createCriteria(Bus.class).list();
        }
        catch (Exception exc)
        {

        }
        finally
        {
            if(session!=null && session.isOpen())
                session.close();
        }
        return busses;
    }

    @Override
    public void deleteBus(Bus bus) throws SQLException {
        Session session = null;
        Transaction tx = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();

            tx = session.beginTransaction();
            session.delete(bus);
            tx.commit();
        }
        catch (Exception exc)
        {
            if(tx!=null)
                tx.rollback();
            throw exc;
        }
        finally
        {
            if(session!=null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void mergeBus(Bus bus)  throws SQLException{
        Session session = null;
        Transaction tx = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();

            tx = session.beginTransaction();
            session.merge(bus);
            tx.commit();
        }
        catch (Exception exc)
        {
            if(tx!=null)
                tx.rollback();
            throw exc;
        }
        finally
        {
            if(session!=null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void replicateBus(Bus bus)  throws SQLException{
        Session session = null;
        Transaction tx = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();

            tx = session.beginTransaction();
            session.replicate(bus,ReplicationMode.OVERWRITE);
            tx.commit();

        }
        catch (Exception exc)
        {
            if(tx!=null)
                tx.rollback();
            throw exc;
        }
        finally
        {
            if(session!=null && session.isOpen())
                session.close();
        }
    }
}
