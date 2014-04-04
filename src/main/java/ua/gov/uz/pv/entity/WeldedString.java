/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.uz.pv.entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author œ√Ã
 */
public class WeldedString {

    public WeldedString() {
    }
    private String railway;
    private String firm;
    private String direction;
    private Integer line;
    private String rail;
    private Integer temperature;
    private Date dateOfWeld;
    private String projectNumber;
    private Integer optimizedIntOfHoldingFrom;
    private Integer optimizedIntOfHoldingTo;
    private Integer calculatedIntOfHoldingFrom;
    private Integer calculatedIntOfHoldingTo;
    private Integer kmS;
    private Integer pkS;
    private Integer mS;
    private Integer kmE;
    private Integer pkE;
    private Integer mE;
    private Integer length;
    private List<Defekt> defekt;
    
    public String getRailway() {
        return railway;
    }

    public void setRailway(String railway) {
        this.railway = railway;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Date getDateOfWeld() {
        return dateOfWeld;
    }

    public void setDateOfWeld(Date dateOfWeld) {
        this.dateOfWeld = dateOfWeld;
    }



    public Integer getOptimizedIntOfHoldingFrom() {
        return optimizedIntOfHoldingFrom;
    }

    public void setOptimizedIntOfHoldingFrom(Integer optimizedIntOfHoldingFrom) {
        this.optimizedIntOfHoldingFrom = optimizedIntOfHoldingFrom;
    }

    public Integer getOptimizedIntOfHoldingTo() {
        return optimizedIntOfHoldingTo;
    }

    public void setOptimizedIntOfHoldingTo(Integer optimizedIntOfHoldingTo) {
        this.optimizedIntOfHoldingTo = optimizedIntOfHoldingTo;
    }

    public Integer getCalculatedIntOfHoldingFrom() {
        return calculatedIntOfHoldingFrom;
    }

    public void setCalculatedIntOfHoldingFrom(Integer calculatedIntOfHoldingFrom) {
        this.calculatedIntOfHoldingFrom = calculatedIntOfHoldingFrom;
    }

    public Integer getCalculatedIntOfHoldingTo() {
        return calculatedIntOfHoldingTo;
    }

    public void setCalculatedIntOfHoldingTo(Integer calculatedIntOfHoldingTo) {
        this.calculatedIntOfHoldingTo = calculatedIntOfHoldingTo;
    }

    public Integer getKmS() {
        return kmS;
    }

    public void setKmS(Integer kmS) {
        this.kmS = kmS;
    }

    public Integer getPkS() {
        return pkS;
    }

    public void setPkS(Integer pkS) {
        this.pkS = pkS;
    }

    public Integer getmS() {
        return mS;
    }

    public void setmS(Integer mS) {
        this.mS = mS;
    }

    public Integer getKmE() {
        return kmE;
    }

    public void setKmE(Integer kmE) {
        this.kmE = kmE;
    }

    public Integer getPkE() {
        return pkE;
    }

    public void setPkE(Integer pkE) {
        this.pkE = pkE;
    }

    public Integer getmE() {
        return mE;
    }

    public void setmE(Integer mE) {
        this.mE = mE;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String getRail() {
        return rail;
    }

    public void setRail(String rail) {
        this.rail = rail;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public List<Defekt> getDefekt() {
        return defekt;
    }

    public void setDefekt(List<Defekt> defekt) {
        this.defekt = defekt;
    }
}
