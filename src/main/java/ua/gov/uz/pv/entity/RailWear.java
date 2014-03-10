

package ua.gov.uz.pv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="rail_wear")
public class RailWear {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private int year;
    private float horizontalWear;
    private float verticalWear;
    private float corrugatedWear;
    @ManyToOne
    @JoinColumn(name="idRails",referencedColumnName="idRail")
    private RailsCharacteristics railsCharacteristics;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getHorizontalWear() {
        return horizontalWear;
    }

    public void setHorizontalWear(float horizontalWear) {
        this.horizontalWear = horizontalWear;
    }

    public float getVerticalWear() {
        return verticalWear;
    }

    public void setVerticalWear(float verticalWear) {
        this.verticalWear = verticalWear;
    }

    public float getCorrugatedWear() {
        return corrugatedWear;
    }

    public void setCorrugatedWear(float corrugatedWear) {
        this.corrugatedWear = corrugatedWear;
    }

    public RailsCharacteristics getRailsCharacteristics() {
        return railsCharacteristics;
    }

    public void setRailsCharacteristics(RailsCharacteristics railsCharacteristics) {
        this.railsCharacteristics = railsCharacteristics;
    }
}
