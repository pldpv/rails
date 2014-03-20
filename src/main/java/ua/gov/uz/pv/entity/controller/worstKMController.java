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
import ua.gov.uz.pv.entity.Railway;
import ua.gov.uz.pv.entity.dao.RailwayDAO;

/**
 *
 * @author œ√Ã
 */
@ManagedBean(name = "worstKM")
@SessionScoped
public class worstKMController {
    private Integer selectedRailway;

    public worstKMController() {
    }
    public List<Railway> getAllRailways(){
        List<Railway> railways=new ArrayList<Railway>();
        RailwayDAO railwayDao=new RailwayDAO();
        railways=railwayDao.getAllRailways();
        return railways;
    }

    public Integer getSelectedRailway() {
        return selectedRailway;
    }

    public void setSelectedRailway(Integer selectedRailway) {
        this.selectedRailway = selectedRailway;
    }
}
