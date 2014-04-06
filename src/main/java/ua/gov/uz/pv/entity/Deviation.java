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
import org.hibernate.annotations.Formula;


@Entity
public class Deviation implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
   
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateMeasuring;
    private String measuring;
    private Integer line;
    private Integer pchu;
    private Integer pd;
    private Integer pdb;
    private Integer km;
    private Integer m;
    private String deviation;
    private Integer level;
    private Integer excursion;
    private Integer deviationLength;
    private Integer rate;
    @ManyToOne
    @JoinColumn(name = "idRailway", referencedColumnName = "idRailway")
    private Railway railway;
    @ManyToOne
    @JoinColumn(name = "idDirection", referencedColumnName = "idDirection")
    private Direction direction;
    @ManyToOne
    @JoinColumn(name = "namePch", referencedColumnName = "nameFirm")
    private Firm firm;
    @Formula("km*1000+m")
    private Integer coordinate;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  
    public String getMeasuring() {
        return measuring;
    }

    public void setMeasuring(String measuring) {
        this.measuring = measuring;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getPchu() {
        return pchu;
    }

    public void setPchu(Integer pchu) {
        this.pchu = pchu;
    }

    public Integer getPd() {
        return pd;
    }

    public void setPd(Integer pd) {
        this.pd = pd;
    }

    public Integer getPdb() {
        return pdb;
    }

    public void setPdb(Integer pdb) {
        this.pdb = pdb;
    }

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

    public String getDeviation() {
        return deviation;
    }

    public void setDeviation(String deviation) {
        this.deviation = deviation;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExcursion() {
        return excursion;
    }

    public void setExcursion(Integer excursion) {
        this.excursion = excursion;
    }

    public Integer getDeviationLength() {
        return deviationLength;
    }

    public void setDeviationLength(Integer deviationLength) {
        this.deviationLength = deviationLength;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
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

    public Date getDateMeasuring() {
        return dateMeasuring;
    }

    public void setDateMeasuring(Date dateMeasuring) {
        this.dateMeasuring = dateMeasuring;
    }

    public Integer getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Integer coordinate) {
        this.coordinate = coordinate;
    }

 
}
