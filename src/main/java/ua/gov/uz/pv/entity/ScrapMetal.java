package ua.gov.uz.pv.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
@Entity(name="scrap_metal")
@PrimaryKeyJoinColumn(name="id",referencedColumnName="id")
public class ScrapMetal extends RailsLocation {
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateScrapping;
    private String whoScrapped;    
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
}
