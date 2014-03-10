package ua.gov.uz.pv.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity(name="rails_characteristics")
public class RailsCharacteristics implements Serializable{
    @Id
    @GeneratedValue
    private int idRail;
    @Column
    private String typeRails;
    private String factory;
    private int numberOfFusion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfRoll;
    private String typeOfTemper;
    private float passTonnage;
    private float railLength;
    private String bondTypeS;
    private String bondTypeE;

    public int getIdRail() {
        return idRail;
    }

    public void setIdRail(int idRail) {
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

    public int getNumberOfFusion() {
        return numberOfFusion;
    }

    public void setNumberOfFusion(int numberOfFusion) {
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

    public float getPassTonnage() {
        return passTonnage;
    }

    public void setPassTonnage(float passTonnage) {
        this.passTonnage = passTonnage;
    }

    public float getRailLength() {
        return railLength;
    }

    public void setRailLength(float railLength) {
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
}
