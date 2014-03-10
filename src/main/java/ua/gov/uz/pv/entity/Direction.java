package ua.gov.uz.pv.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="direction")
public class Direction implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    @Column
    private int idDirection;
    private String nameDirection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDirection() {
        return idDirection;
    }

    public void setIdDirection(int idDirection) {
        this.idDirection = idDirection;
    }

    public String getNameDirection() {
        return nameDirection;
    }

    public void setNameDirection(String nameDirection) {
        this.nameDirection = nameDirection;
    }
}
