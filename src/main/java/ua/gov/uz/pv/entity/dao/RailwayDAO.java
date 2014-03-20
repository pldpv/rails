/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.uz.pv.entity.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import ua.gov.uz.pv.entity.Railway;
import ua.gov.uz.pv.util.HibernateUtil;

/**
 *
 * @author ПГМ
 */
public class RailwayDAO {

    Session session = null;

    public List getAllRailways() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Railway> result = null;
        result = session.createCriteria(Railway.class).list();
        return result;
    }
    public Railway getRailwayByName(String name){
        Railway result=null;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        result=(Railway)session.load(Railway.class,name);
        return result;
    }

    public void addRailway(Railway railway) throws SQLException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(railway);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Онибка добавления в БД");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public void addRailways(List<Railway> railways) throws SQLException{
        for (Railway railway:railways) addRailway(railway);
    }
    public void deleteRailway(Railway railway){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(railway);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Онибка добавления в БД");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
