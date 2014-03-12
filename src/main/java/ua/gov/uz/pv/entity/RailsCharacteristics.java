package ua.gov.uz.pv.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;

@Entity(name="rails_characteristics")
public class RailsCharacteristics implements Serializable{
    @Id
    @GeneratedValue
    private Integer idRail;
    @Column
    private String typeRails;
    private String factory;
    private Integer numberOfFusion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfRoll;
    private String typeOfTemper;
    private Float passTonnage;
    private Float railLength;
    private String bondTypeS;
    private String bondTypeE;
    @OneToMany(fetch=FetchType.EAGER,mappedBy="railsCharacteristics")
    @Cascade(value=org.hibernate.annotations.CascadeType.ALL)
    private List<RailsLocation> railsLocation;

    public Integer getIdRail() {
        return idRail;
    }

    public void setIdRail(Integer idRail) {
        this.idRail = idRail;
    }

    public String getTypeRails() {
        return typeRails;
    }

    public void setTypeRails(String typeRails) {
        this.typeRails = typeRails;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public Integer getNumberOfFusion() {
        return numberOfFusion;
    }

    public void setNumberOfFusion(Integer numberOfFusion) {
        this.numberOfFusion = numberOfFusion;
    }

    public Date getDateOfRoll() {
        return dateOfRoll;
    }

    public void setDateOfRoll(Date dateOfRoll) {
        this.dateOfRoll = dateOfRoll;
    }

    public String getTypeOfTemper() {
        return typeOfTemper;
    }

    public void setTypeOfTemper(String typeOfTemper) {
        this.typeOfTemper = typeOfTemper;
    }

    public Float getPassTonnage() {
        return passTonnage;
    }

    public void setPassTonnage(Float passTonnage) {
        this.passTonnage = passTonnage;
    }

    public Float getRailLength() {
        return railLength;
    }

    public void setRailLength(Float railLength) {
        this.railLength = railLength;
    }

    public String getBondTypeS() {
        return bondTypeS;
    }

    public void setBondTypeS(String bondTypeS) {
        this.bondTypeS = bondTypeS;
    }

    public String getBondTypeE() {
        return bondTypeE;
    }

    public void setBondTypeE(String bondTypeE) {
        this.bondTypeE = bondTypeE;
    }

    public List<RailsLocation> getRailsLocation() {
        return railsLocation;
    }

    public void setRailsLocation(List<RailsLocation> railsLocation) {
        this.railsLocation = railsLocation;
    }
    
}
