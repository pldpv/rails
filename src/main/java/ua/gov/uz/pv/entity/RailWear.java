package ua.gov.uz.pv.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="rail_wear")
public class RailWear implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private Integer year;
    private Float horizontalWear;
    private Float verticalWear;
    private Float corrugatedWear;
    private Integer idRails;
    @ManyToOne
    @JoinColumn(name="idRails")
    private RailsCharacteristics railsCharacteristics;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getHorizontalWear() {
        return horizontalWear;
    }

    public void setHorizontalWear(Float horizontalWear) {
        this.horizontalWear = horizontalWear;
    }

    public Float getVerticalWear() {
        return verticalWear;
    }

    public void setVerticalWear(Float verticalWear) {
        this.verticalWear = verticalWear;
    }

    public Float getCorrugatedWear() {
        return corrugatedWear;
    }

    public void setCorrugatedWear(Float corrugatedWear) {
        this.corrugatedWear = corrugatedWear;
    }

    public Integer getIdRails() {
        return idRails;
    }

    public void setIdRails(Integer idRails) {
        this.idRails = idRails;
    }

    public RailsCharacteristics getRailsCharacteristics() {
        return railsCharacteristics;
    }

    public void setRailsCharacteristics(RailsCharacteristics railsCharacteristics) {
        this.railsCharacteristics = railsCharacteristics;
    }
}
