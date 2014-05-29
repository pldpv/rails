/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.uz.pv.entity.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import ua.gov.uz.pv.entity.Deviation;
import ua.gov.uz.pv.entity.Railway;
import ua.gov.uz.pv.util.HibernateUtil;

/**
 *
 * @author œ√Ã
 */
@ManagedBean(name="worstKM")
@SessionScoped

public class worstKMController {
    Session session = null;
    private Integer selectedRailway;
    private Date startDate;
    private Date endDate;
    private boolean result=false;
    private boolean notFound=false;

    public worstKMController() {
    }
    public List<Railway> getAllRailways(){
        List<Railway> result=new ArrayList<Railway>();
        session = HibernateUtil.getSessionFactory().openSession();
        result = session.createCriteria(Railway.class).list();
        return result;
    }
    public void navigate(){
        List <Deviation> result;
        result=getWorstPch();
        if (!result.isEmpty()) {
            setResult(true);
        }else{setNotFound(true);}
    }
    public List getWorstPch(){
        List <Deviation> otst;
        otst = (List<Deviation>) session.createCriteria(Deviation.class)
                .add(Restrictions.between("dateMeasuring", getStartDate(), getEndDate()))
                .setFetchMode("direction", FetchMode.JOIN)
                .setFetchMode("railway", FetchMode.JOIN)
                .add(Restrictions.eq("railway.idRailway", selectedRailway))
                .setProjection(Projections.projectionList()
                    .add(Projections.groupProperty("direction"))
                    .add(Projections.groupProperty("line"))
                    .add(Projections.groupProperty("km"))
                    .add(Projections.groupProperty("m"))
                    .add(Projections.rowCount(),"deviation")
                )
                .list();
        return otst;
    }
    public Integer getSelectedRailway() {
        return selectedRailway;
    }

    public void setSelectedRailway(Integer selectedRailway) {
        this.selectedRailway = selectedRailway;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isNotFound() {
        return notFound;
    }

    public void setNotFound(boolean notFound) {
        this.notFound = notFound;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
