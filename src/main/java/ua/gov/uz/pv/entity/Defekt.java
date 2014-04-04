/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.uz.pv.entity;

/**
 *
 * @author œ√Ã
 */
public class Defekt {

    public Defekt(Integer km, Integer m, String kod, Float length, Float h, Float x) {
        this.km = km;
        this.m = m;
        this.kod = kod;
        this.length = length;
        this.h = h;
        this.x = x;
    }
    
    private Integer km,m;
    private String kod;
    private Float length,h,x;
    
    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Integer getM() {
        return m;
    }

    public void setM(Integer m) {
        this.m = m;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getH() {
        return h;
    }

    public void setH(Float h) {
        this.h = h;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }
    
}
