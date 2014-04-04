package ua.gov.uz.pv.entity.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ua.gov.uz.pv.entity.Deviation;
import ua.gov.uz.pv.entity.Firm;
import ua.gov.uz.pv.entity.PchDirection;
import ua.gov.uz.pv.entity.Railway;
import ua.gov.uz.pv.entity.WorkingCapacity;
import ua.gov.uz.pv.util.HibernateUtil;

@ManagedBean(name="analizKM")
@SessionScoped
public class AnalizKMController {
    private Session session = null;
    private Integer selectedRailway;
    private String selectedPch;
    private Integer selectedDirection;
    private Integer selectedKm;
    private Integer selectedLine;
    private GregorianCalendar gcFirst,gcLast;

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
    public List<WorkingCapacity> getWorkingCapacityByKM(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<WorkingCapacity> result=new ArrayList<WorkingCapacity>();
        result=session.createCriteria(WorkingCapacity.class)
                .setFetchMode("railway", FetchMode.JOIN)
                .setFetchMode("firm", FetchMode.JOIN)
                .setFetchMode("direction", FetchMode.JOIN)
                .add(Restrictions.eq("railway.idRailway", selectedRailway))
                .add(Restrictions.eq("firm.nameFirm", selectedPch))
                .add(Restrictions.eq("direction.idDirection", selectedDirection))
                .add(Restrictions.eq("line", selectedLine))
                .add(Restrictions.lt("kmS", selectedKm))
                .add(Restrictions.gt("kmE", selectedKm))
                .list();
        session.close();
        return result;
    }
    public List<Deviation> getDeviationByKM(){
        gcLast=new GregorianCalendar();
        gcLast.add(Calendar.MONTH, -12);
        session = HibernateUtil.getSessionFactory().openSession();
        List<Deviation> result=new ArrayList<Deviation>();
        result=session.createCriteria(Deviation.class)
                .setFetchMode("railway", FetchMode.JOIN)
                .setFetchMode("firm", FetchMode.JOIN)
                .setFetchMode("direction", FetchMode.JOIN)
         
                .add(Restrictions.eq("railway.idRailway", selectedRailway))
                .add(Restrictions.eq("firm.nameFirm", selectedPch))
                .add(Restrictions.eq("direction.idDirection", selectedDirection))
                .add(Restrictions.eq("line", selectedLine))
                .add(Restrictions.eq("km", selectedKm))
                .list();
        session.close();
        return result;
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
