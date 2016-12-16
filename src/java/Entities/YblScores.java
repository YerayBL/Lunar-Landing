/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

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
 * @author yeray
 */
@Entity
@Table(name = "ybl_scores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "YblScores.findAll", query = "SELECT y FROM YblScores y"),
    @NamedQuery(name = "YblScores.findByScId", query = "SELECT y FROM YblScores y WHERE y.scId = :scId"),
    @NamedQuery(name = "YblScores.findByIniDate", query = "SELECT y FROM YblScores y WHERE y.iniDate = :iniDate"),
    @NamedQuery(name = "YblScores.findByEndDate", query = "SELECT y FROM YblScores y WHERE y.endDate = :endDate"),
    @NamedQuery(name = "YblScores.findByScore", query = "SELECT y FROM YblScores y WHERE y.score = :score")})
public class YblScores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sc_id")
    private Integer scId;
    @Basic(optional = false)
    @Column(name = "ini_date")
    @Temporal(TemporalType.DATE)
    private Date iniDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "score")
    private double score;
    @JoinColumn(name = "us_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private YblUsers usId;

    public YblScores() {
    }

    public YblScores(Integer scId) {
        this.scId = scId;
    }

    public YblScores(Integer scId, Date iniDate, Date endDate, double score) {
        this.scId = scId;
        this.iniDate = iniDate;
        this.endDate = endDate;
        this.score = score;
    }

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public Date getIniDate() {
        return iniDate;
    }

    public void setIniDate(Date iniDate) {
        this.iniDate = iniDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public YblUsers getUsId() {
        return usId;
    }

    public void setUsId(YblUsers usId) {
        this.usId = usId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scId != null ? scId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof YblScores)) {
            return false;
        }
        YblScores other = (YblScores) object;
        if ((this.scId == null && other.scId != null) || (this.scId != null && !this.scId.equals(other.scId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.YblScores[ scId=" + scId + " ]";
    }
    
}
