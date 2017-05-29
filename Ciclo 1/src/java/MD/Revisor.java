/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALIENWARE
 */
@Entity
@Table(name = "revisor", catalog = "easytranslation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revisor.findAll", query = "SELECT r FROM Revisor r")
    , @NamedQuery(name = "Revisor.findByCorreoelectronicoRe", query = "SELECT r FROM Revisor r WHERE r.correoelectronicoRe = :correoelectronicoRe")
    , @NamedQuery(name = "Revisor.findByNombreRe", query = "SELECT r FROM Revisor r WHERE r.nombreRe = :nombreRe")})
public class Revisor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "correoelectronico_re")
    private String correoelectronicoRe;
    @Size(max = 254)
    @Column(name = "nombre_re")
    private String nombreRe;
    @JoinColumn(name = "abreviacion_id", referencedColumnName = "abreviacion_id")
    @ManyToOne
    private Idioma abreviacionId;

    public Revisor() {
    }

    public Revisor(String correoelectronicoRe) {
        this.correoelectronicoRe = correoelectronicoRe;
    }

    public String getCorreoelectronicoRe() {
        return correoelectronicoRe;
    }

    public void setCorreoelectronicoRe(String correoelectronicoRe) {
        this.correoelectronicoRe = correoelectronicoRe;
    }

    public String getNombreRe() {
        return nombreRe;
    }

    public void setNombreRe(String nombreRe) {
        this.nombreRe = nombreRe;
    }

    public Idioma getAbreviacionId() {
        return abreviacionId;
    }

    public void setAbreviacionId(Idioma abreviacionId) {
        this.abreviacionId = abreviacionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correoelectronicoRe != null ? correoelectronicoRe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revisor)) {
            return false;
        }
        Revisor other = (Revisor) object;
        if ((this.correoelectronicoRe == null && other.correoelectronicoRe != null) || (this.correoelectronicoRe != null && !this.correoelectronicoRe.equals(other.correoelectronicoRe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MD.Revisor[ correoelectronicoRe=" + correoelectronicoRe + " ]";
    }
    
}
