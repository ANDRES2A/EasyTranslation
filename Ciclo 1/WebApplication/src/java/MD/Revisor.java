/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ALIENWARE
 */
@Entity
@Table(name = "REVISOR", catalog = "", schema = "EASYTRANSLATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revisor.findAll", query = "SELECT r FROM Revisor r")
    , @NamedQuery(name = "Revisor.findByCorreoRe", query = "SELECT r FROM Revisor r WHERE r.correoRe = :correoRe")
    , @NamedQuery(name = "Revisor.findByNombreRe", query = "SELECT r FROM Revisor r WHERE r.nombreRe = :nombreRe")
    , @NamedQuery(name = "Revisor.findByPasswordRe", query = "SELECT r FROM Revisor r WHERE r.passwordRe = :passwordRe")
    , @NamedQuery(name = "Revisor.findByFechaNacimientoRe", query = "SELECT r FROM Revisor r WHERE r.fechaNacimientoRe = :fechaNacimientoRe")
    , @NamedQuery(name = "Revisor.findByExperiencia", query = "SELECT r FROM Revisor r WHERE r.experiencia = :experiencia")})
public class Revisor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CORREO_RE")
    private String correoRe;
    @Size(max = 100)
    @Column(name = "NOMBRE_RE")
    private String nombreRe;
    @Size(max = 255)
    @Column(name = "PASSWORD_RE")
    private String passwordRe;
    @Column(name = "FECHA_NACIMIENTO_RE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimientoRe;
    @Size(max = 10)
    @Column(name = "EXPERIENCIA")
    private String experiencia;
    @ManyToMany(mappedBy = "revisorCollection")
    private Collection<Idioma> idiomaCollection;

    public Revisor() {
    }

    public Revisor(String correoRe) {
        this.correoRe = correoRe;
    }

    public String getCorreoRe() {
        return correoRe;
    }

    public void setCorreoRe(String correoRe) {
        this.correoRe = correoRe;
    }

    public String getNombreRe() {
        return nombreRe;
    }

    public void setNombreRe(String nombreRe) {
        this.nombreRe = nombreRe;
    }

    public String getPasswordRe() {
        return passwordRe;
    }

    public void setPasswordRe(String passwordRe) {
        this.passwordRe = passwordRe;
    }

    public Date getFechaNacimientoRe() {
        return fechaNacimientoRe;
    }

    public void setFechaNacimientoRe(Date fechaNacimientoRe) {
        this.fechaNacimientoRe = fechaNacimientoRe;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    @XmlTransient
    public Collection<Idioma> getIdiomaCollection() {
        return idiomaCollection;
    }

    public void setIdiomaCollection(Collection<Idioma> idiomaCollection) {
        this.idiomaCollection = idiomaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correoRe != null ? correoRe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revisor)) {
            return false;
        }
        Revisor other = (Revisor) object;
        if ((this.correoRe == null && other.correoRe != null) || (this.correoRe != null && !this.correoRe.equals(other.correoRe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MD.Revisor[ correoRe=" + correoRe + " ]";
    }
    
}
