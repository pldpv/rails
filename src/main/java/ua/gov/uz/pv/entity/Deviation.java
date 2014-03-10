package ua.gov.uz.pv.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Deviation implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateMeasuring;
    private String measuring;
    private int line;
    private int pchu;
    private int pd;
    private int pdb;
    private int km;
    private int m;
    private String deviation;
    private int level;
    private int excursion;
    private int length;
    private int rate;
    @ManyToOne
    @JoinColumn(name = "idRailway", referencedColumnName = "idRailway")
    private Railway railway;
    @ManyToOne
    @JoinColumn(name = "idDirection", referencedColumnName = "idDirection")
    private Direction direction;
    @ManyToOne
    @JoinColumn(name = "namePch", referencedColumnName = "nameFirm")
    private Firm firm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateMeasuring() {
        return dateMeasuring;
    }

    public void setDateMeasuring(Date dateMeasuring) {
        this.dateMeasuring = dateMeasuring;
    }

    public String getMeasuring() {
        return measuring;
    }

    public void setMeasuring(String measuring) {
        this.measuring = measuring;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getPchu() {
        return pchu;
    }

    public void setPchu(int pchu) {
        this.pchu = pchu;
    }

    public int getPd() {
        return pd;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public int getPdb() {
        return pdb;
    }

    public void setPdb(int pdb) {
        this.pdb = pdb;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public String getDeviation() {
        return deviation;
    }

    public void setDeviation(String deviation) {
        this.deviation = deviation;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExcursion() {
        return excursion;
    }

    public void setExcursion(int excursion) {
        this.excursion = excursion;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Railway getRailway() {
        return railway;
    }

    public void setRailway(Railway railway) {
        this.railway = railway;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }
}
