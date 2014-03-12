
package ua.gov.uz.pv.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="railsLocation")
@Inheritance(strategy=InheritanceType.JOINED)
public class RailsLocation implements Serializable {
    @Id
    @Column(name="id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="idRails",nullable=false,insertable=true,updatable=true)
    private RailsCharacteristics railsCharacteristics;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RailsCharacteristics getRailsCharacteristics() {
        return railsCharacteristics;
    }

    public void setRailsCharacteristics(RailsCharacteristics railsCharacteristics) {
        this.railsCharacteristics = railsCharacteristics;
    }

   
}
