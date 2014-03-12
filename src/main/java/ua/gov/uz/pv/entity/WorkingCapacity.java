
package ua.gov.uz.pv.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="working_capacity")
public class WorkingCapacity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private Integer line;
    private Integer kmS;
    private Integer mS;
    private Integer kmE;
    private Integer mE;
    private Float workingCapacity;
    @ManyToOne
    @JoinColumn(name="idRailway",referencedColumnName="idRailway")
    private Railway railway;
    @ManyToOne
    @JoinColumn(name="idDirection",referencedColumnName="idDirection")
    private Direction direction;
    @ManyToOne
    @JoinColumn(name="namePch",referencedColumnName="nameFirm")
    private Firm firm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getKmS() {
        return kmS;
    }

    public void setKmS(Integer kmS) {
        this.kmS = kmS;
    }

    public Integer getmS() {
        return mS;
    }

    public void setmS(Integer mS) {
        this.mS = mS;
    }

    public Integer getKmE() {
        return kmE;
    }

    public void setKmE(Integer kmE) {
        this.kmE = kmE;
    }

    public Integer getmE() {
        return mE;
    }

    public void setmE(Integer mE) {
        this.mE = mE;
    }

    public Float getWorkingCapacity() {
        return workingCapacity;
    }

    public void setWorkingCapacity(Float workingCapacity) {
        this.workingCapacity = workingCapacity;
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
