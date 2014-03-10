package ua.gov.uz.pv.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class GovernedVelocity implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private int line;
    private int kmS;
    private int mS;
    private int kmE;
    private int mE;
    private int passengerVelocity;
    private int freightVelocity;
    private int uptownVelocity;
    private String cause;
    @ManyToOne
    @JoinColumn(name="idRailway",referencedColumnName="idRailway")
    private Railway railway;
    @ManyToOne
    @JoinColumn(name="idDirection",referencedColumnName="idDirection")
    private Direction direction;
    @ManyToOne
    @JoinColumn(name="namePch",referencedColumnName="nameFirm")
    private Firm firm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getKmS() {
        return kmS;
    }

    public void setKmS(int kmS) {
        this.kmS = kmS;
    }

    public int getmS() {
        return mS;
    }

    public void setmS(int mS) {
        this.mS = mS;
    }

    public int getKmE() {
        return kmE;
    }

    public void setKmE(int kmE) {
        this.kmE = kmE;
    }

    public int getmE() {
        return mE;
    }

    public void setmE(int mE) {
        this.mE = mE;
    }

    public int getPassengerVelocity() {
        return passengerVelocity;
    }

    public void setPassengerVelocity(int passengerVelocity) {
        this.passengerVelocity = passengerVelocity;
    }

    public int getFreightVelocity() {
        return freightVelocity;
    }

    public void setFreightVelocity(int freightVelocity) {
        this.freightVelocity = freightVelocity;
    }

    public int getUptownVelocity() {
        return uptownVelocity;
    }

    public void setUptownVelocity(int uptownVelocity) {
        this.uptownVelocity = uptownVelocity;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
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
