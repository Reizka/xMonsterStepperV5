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
@Table(name = "calories_burned")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaloriesBurned.findAll", query = "SELECT c FROM CaloriesBurned c"),
    @NamedQuery(name = "CaloriesBurned.findByKcalBurned", query = "SELECT c FROM CaloriesBurned c WHERE c.kcalBurned = :kcalBurned"),
    @NamedQuery(name = "CaloriesBurned.findByDay", query = "SELECT c FROM CaloriesBurned c WHERE c.day = :day"),
    @NamedQuery(name = "CaloriesBurned.findById", query = "SELECT c FROM CaloriesBurned c WHERE c.id = :id")})
public class CaloriesBurned implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "kcal_burned")
    private Integer kcalBurned;
    @Column(name = "day")
    @Temporal(TemporalType.DATE)
    private Date day;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "player_phone", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Player playerPhone;

    public CaloriesBurned() {
    }

    public CaloriesBurned(Integer id) {
        this.id = id;
    }

    public Integer getKcalBurned() {
        return kcalBurned;
    }

    public void setKcalBurned(Integer kcalBurned) {
        this.kcalBurned = kcalBurned;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaloriesBurned)) {
            return false;
        }
        CaloriesBurned other = (CaloriesBurned) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CaloriesBurned[ id=" + id + " ]";
    }
    
}
