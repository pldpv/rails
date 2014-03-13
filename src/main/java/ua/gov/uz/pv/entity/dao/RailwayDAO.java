/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.uz.pv.entity.dao;

import java.util.List;
import org.hibernate.Session;
import ua.gov.uz.pv.entity.Railway;
import ua.gov.uz.pv.util.HibernateUtil;

/**
 *
 * @author œ√Ã
 */
public class RailwayDAO extends Dao {

    public List getRailways() {
        List<Railway> result = null;
        result = session.createCriteria(Railway.class).list();
        return result;
    }
}
