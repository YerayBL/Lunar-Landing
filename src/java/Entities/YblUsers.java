/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yeray
 */
@Entity
@Table(name = "ybl_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "YblUsers.findAll", query = "SELECT y FROM YblUsers y"),
    @NamedQuery(name = "YblUsers.findById", query = "SELECT y FROM YblUsers y WHERE y.id = :id"),
    @NamedQuery(name = "YblUsers.findByUser", query = "SELECT y FROM YblUsers y WHERE y.user = :user"),
    @NamedQuery(name = "YblUsers.findByPasswd", query = "SELECT y FROM YblUsers y WHERE y.passwd = :passwd")})
public class YblUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @Column(name = "passwd")
    private String passwd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usId")
    private Collection<YblScores> yblScoresCollection;

    public YblUsers() {
    }

    public YblUsers(Integer id) {
        this.id = id;
    }

    public YblUsers(Integer id, String user, String passwd) {
        this.id = id;
        this.user = user;
        this.passwd = passwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @XmlTransient
    public Collection<YblScores> getYblScoresCollection() {
        return yblScoresCollection;
    }

    public void setYblScoresCollection(Collection<YblScores> yblScoresCollection) {
        this.yblScoresCollection = yblScoresCollection;
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
        if (!(object instanceof YblUsers)) {
            return false;
        }
        YblUsers other = (YblUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.YblUsers[ id=" + id + " ]";
    }
    
}
