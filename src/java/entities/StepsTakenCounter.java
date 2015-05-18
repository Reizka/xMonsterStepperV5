/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renny
 */
@Entity
@Table(name = "steps_taken_counter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StepsTakenCounter.findAll", query = "SELECT s FROM StepsTakenCounter s"),
    @NamedQuery(name = "StepsTakenCounter.findBySteps", query = "SELECT s FROM StepsTakenCounter s WHERE s.steps = :steps"),
    @NamedQuery(name = "StepsTakenCounter.findByDay", query = "SELECT s FROM StepsTakenCounter s WHERE s.day = :day"),
    @NamedQuery(name = "StepsTakenCounter.findById", query = "SELECT s FROM StepsTakenCounter s WHERE s.id = :id")})
public class StepsTakenCounter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "steps")
    private Integer steps;
    @Column(name = "day")
    @Temporal(TemporalType.DATE)
    private Date day;
    @Column(name="duration")
    private double duration;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "player_phone", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Player playerPhone;

    public StepsTakenCounter() {
    }

    public StepsTakenCounter(Integer id) {
        this.id = id;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayerPhone() {
        return playerPhone;
    }

    public void setPlayerPhone(Player playerPhone) {
        this.playerPhone = playerPhone;
    }
      public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StepsTakenCounter)) {
            return false;
        }
        StepsTakenCounter other = (StepsTakenCounter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.StepsTakenCounter[ id=" + id + " ]";
    }
    
}
