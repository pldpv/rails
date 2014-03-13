/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.uz.pv.entity.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import ua.gov.uz.pv.entity.Deviation;

/**
 *
 * @author œ√Ã
 */
public class DeviationDao extends Dao{
    public List getWorstKm(Integer idRailway,Date firstDate,Date lastDate){
        List<Deviation> result=null;
        result=session.createCriteria(Deviation.class)
                .add(Restrictions.between("date", firstDate, lastDate))
        return result;
    }
}
