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
    private Integer id;
    @Column
    private Integer idRailway;
    private String nameRailway;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdRailway() {
        return idRailway;
    }

    public void setIdRailway(Integer idRailway) {
        this.idRailway = idRailway;
    }

    public String getNameRailway() {
        return nameRailway;
    }

    public void setNameRailway(String nameRailway) {
        this.nameRailway = nameRailway;
    }

}
