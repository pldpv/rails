package ua.gov.uz.pv.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
@Entity(name="scrap_metal")
public class ScrapMetal implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateScrapping;
    private String whoScrapped;
    @ManyToOne
    @JoinColumn(name="idRails",referencedColumnName="idRail")
    private RailsCharacteristics railsCharacteristics;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateScrapping() {
        return dateScrapping;
    }

    public void setDateScrapping(Date dateScrapping) {
        this.dateScrapping = dateScrapping;
    }

    public String getWhoScrapped() {
        return whoScrapped;
    }

    public void setWhoScrapped(String whoScrapped) {
        this.whoScrapped = whoScrapped;
    }

    public RailsCharacteristics getRailsCharacteristics() {
        return railsCharacteristics;
    }

    public void setRailsCharacteristics(RailsCharacteristics railsCharacteristics) {
        this.railsCharacteristics = railsCharacteristics;
    }
}
