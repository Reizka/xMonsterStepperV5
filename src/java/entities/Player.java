/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Renny
 */
@Entity
@Table(name = "player")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findByName", query = "SELECT p FROM Player p WHERE p.name = :name"),
    @NamedQuery(name = "Player.findByCaloryBurnedTotal", query = "SELECT p FROM Player p WHERE p.caloryBurnedTotal = :caloryBurnedTotal"),
    @NamedQuery(name = "Player.findByStepsTaken", query = "SELECT p FROM Player p WHERE p.stepsTaken = :stepsTaken"),
    @NamedQuery(name = "Player.findByPassword", query = "SELECT p FROM Player p WHERE p.password = :password"),
    @NamedQuery(name = "Player.findById", query = "SELECT p FROM Player p WHERE p.id = :id"),
    @NamedQuery(name = "Player.findByWeight", query = "SELECT p FROM Player p WHERE p.weight = :weight"),
    @NamedQuery(name = "Player.findByExp", query = "SELECT p FROM Player p WHERE p.exp = :exp"),
    @NamedQuery(name = "Player.findByMonsterMoney", query = "SELECT p FROM Player p WHERE p.monsterMoney = :monsterMoney")})
public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Column(name = "calory_burned_total")
    private Integer caloryBurnedTotal;
    @Column(name = "steps_taken")
    private Integer stepsTaken;
    @Size(max = 300)
    @Column(name = "password")
    private String password;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "exp")
    private Integer exp;
    @Column(name = "monster_money")
    private Integer monsterMoney;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerPhone")
    private Collection<CaloriesBurned> caloriesBurnedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerPhone")
    private Collection<StepsTakenCounter> stepsTakenCounterCollection;

    public Player() {
    }

    public Player(Integer id) {
        this.id = id;
    }

    public Player(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCaloryBurnedTotal() {
        return caloryBurnedTotal;
    }

    public void setCaloryBurnedTotal(Integer caloryBurnedTotal) {
        this.caloryBurnedTotal = caloryBurnedTotal;
    }

    public Integer getStepsTaken() {
        return stepsTaken;
    }

    public void setStepsTaken(Integer stepsTaken) {
        this.stepsTaken = stepsTaken;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getMonsterMoney() {
        return monsterMoney;
    }

    public void setMonsterMoney(Integer monsterMoney) {
        this.monsterMoney = monsterMoney;
    }

    @XmlTransient
    public Collection<CaloriesBurned> getCaloriesBurnedCollection() {
        return caloriesBurnedCollection;
    }

    public void setCaloriesBurnedCollection(Collection<CaloriesBurned> caloriesBurnedCollection) {
        this.caloriesBurnedCollection = caloriesBurnedCollection;
    }

    @XmlTransient
    public Collection<StepsTakenCounter> getStepsTakenCounterCollection() {
        return stepsTakenCounterCollection;
    }

    public void setStepsTakenCounterCollection(Collection<StepsTakenCounter> stepsTakenCounterCollection) {
        this.stepsTakenCounterCollection = stepsTakenCounterCollection;
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
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Player[ id=" + id + " ]";
    }
    
}
