/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.uz.pv.entity.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ua.gov.uz.pv.entity.Firm;
import ua.gov.uz.pv.entity.PchDirection;
import ua.gov.uz.pv.entity.Railway;
import ua.gov.uz.pv.util.HibernateUtil;

/**
 *
 * @author œ√Ã
 */
@ManagedBean(name="analizKM")
@SessionScoped
public class AnalizKMController {
    private Session session = null;
    private Integer selectedRailway;
    private String selectedPch;
    private Integer selectedDirection;
    private Integer selectedKm;
    private Integer selectedLine;

    public List<Railway> getAllRailways(){
        List<Railway> result=new ArrayList<Railway>();
        session = HibernateUtil.getSessionFactory().openSession();
        result = session.createCriteria(Railway.class).list();
        session.close();
        return result;
    }
    public List<Firm> getAllFirmsByRailway(){
        List<Firm> result=new ArrayList<Firm>();
        session = HibernateUtil.getSessionFactory().openSession();
        result = session.createCriteria(Firm.class)
                .setFetchMode("railway", FetchMode.JOIN)
                .add(Restrictions.eq("railway.idRailway", selectedRailway))
                .list();
        session.close();
        return result;
    }
    public List<PchDirection> getDirectionByPch(){
        List<PchDirection> result=new ArrayList<PchDirection>();
        session = HibernateUtil.getSessionFactory().openSession();
        result = session.createCriteria(PchDirection.class)
                .setFetchMode("direction", FetchMode.JOIN)
                .setFetchMode("railway", FetchMode.JOIN)
                .setFetchMode("firm", FetchMode.JOIN)
                .add(Restrictions.eq("railway.idRailway", selectedRailway))
                .add(Restrictions.eq("firm.nameFirm", selectedPch))
                .list();
        session.close();
        return result;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Integer getSelectedRailway() {
        return selectedRailway;
    }

    public void setSelectedRailway(Integer selectedRailway) {
        this.selectedRailway = selectedRailway;
    }

    public String getSelectedPch() {
        return selectedPch;
    }

    public void setSelectedPch(String selectedPch) {
        this.selectedPch = selectedPch;
    }

    public Integer getSelectedDirection() {
        return selectedDirection;
    }

    public void setSelectedDirection(Integer selectedDirection) {
        this.selectedDirection = selectedDirection;
    }

    public Integer getSelectedKm() {
        return selectedKm;
    }

    public void setSelectedKm(Integer selectedKm) {
        this.selectedKm = selectedKm;
    }

    public Integer getSelectedLine() {
        return selectedLine;
    }

    public void setSelectedLine(Integer selectedLine) {
        this.selectedLine = selectedLine;
    }
}
