package com.epam.dao;

import com.epam.entity.Bus;
import com.epam.entity.Mini;
import com.epam.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class MiniDAO {

    public void addMini(Mini mini)  throws SQLException {
        Session session = null;
        Transaction tx = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(mini);
            tx.commit();
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
}
