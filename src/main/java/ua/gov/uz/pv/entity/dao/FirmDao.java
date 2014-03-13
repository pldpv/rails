/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.uz.pv.entity.dao;

import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import ua.gov.uz.pv.entity.Firm;

/**
 *
 * @author œ√Ã
 */
public class FirmDao extends Dao{
    public List firmByRailway(Integer idRailway){
        List<Firm> result=null;
        result=session.createCriteria(Firm.class)
                .add(Restrictions.eq("idRailway", idRailway))
                .setFetchMode("idRailway", FetchMode.JOIN)
                .list();
        return result;
    }
}
