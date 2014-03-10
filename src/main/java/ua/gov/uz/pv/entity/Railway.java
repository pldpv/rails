package ua.gov.uz.pv.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "railway")
public class Railway implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private int idRailway;
    private String nameRailway;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRailway() {
        return idRailway;
    }

    public void setIdRailway(int idRailway) {
        this.idRailway = idRailway;
    }

    public String getNameRailway() {
        return nameRailway;
    }

    public void setNameRailway(String nameRailway) {
        this.nameRailway = nameRailway;
    }

}
