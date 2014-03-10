
package ua.gov.uz.pv.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="continious_space_interval")
public class ContiniousSpaceInterval implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    @Column
    private int line;
    private int kmS;
    private int mS;
    private int kmE;
    private int mE;
    @ManyToOne
    @JoinColumn(name="idDirection",referencedColumnName="idDirection")
    private Direction direction;

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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
}
