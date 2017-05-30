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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "USUARIO", catalog = "", schema = "EASYTRANSLATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCorreoUs", query = "SELECT u FROM Usuario u WHERE u.correoUs = :correoUs")
    , @NamedQuery(name = "Usuario.findByNombreUs", query = "SELECT u FROM Usuario u WHERE u.nombreUs = :nombreUs")
    , @NamedQuery(name = "Usuario.findByPasswordUs", query = "SELECT u FROM Usuario u WHERE u.passwordUs = :passwordUs")
    , @NamedQuery(name = "Usuario.findByFechaNacimientoUs", query = "SELECT u FROM Usuario u WHERE u.fechaNacimientoUs = :fechaNacimientoUs")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CORREO_US")
    private String correoUs;
    @Size(max = 100)
    @Column(name = "NOMBRE_US")
    private String nombreUs;
    @Size(max = 255)
    @Column(name = "PASSWORD_US")
    private String passwordUs;
    @Column(name = "FECHA_NACIMIENTO_US")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimientoUs;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Revisor> revisorCollection;
    @JoinTable(name = "SABE", joinColumns = {
        @JoinColumn(name = "CORREO_US", referencedColumnName = "CORREO_US")}, inverseJoinColumns = {
        @JoinColumn(name = "ABREVIACION_ID", referencedColumnName = "ABREVIACION_ID")})
    @ManyToMany
    private Collection<Idioma> idiomaCollection;

    public Usuario() {
    }

    public Usuario(String correoUs) {
        this.correoUs = correoUs;
    }

    public String getCorreoUs() {
        return correoUs;
    }

    public void setCorreoUs(String correoUs) {
        this.correoUs = correoUs;
    }

    public String getNombreUs() {
        return nombreUs;
    }

    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    public String getPasswordUs() {
        return passwordUs;
    }

    public void setPasswordUs(String passwordUs) {
        this.passwordUs = passwordUs;
    }

    public Date getFechaNacimientoUs() {
        return fechaNacimientoUs;
    }

    public void setFechaNacimientoUs(Date fechaNacimientoUs) {
        this.fechaNacimientoUs = fechaNacimientoUs;
    }

    @XmlTransient
    public Collection<Revisor> getRevisorCollection() {
        return revisorCollection;
    }

    public void setRevisorCollection(Collection<Revisor> revisorCollection) {
        this.revisorCollection = revisorCollection;
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
        hash += (correoUs != null ? correoUs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.correoUs == null && other.correoUs != null) || (this.correoUs != null && !this.correoUs.equals(other.correoUs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MD.Usuario[ correoUs=" + correoUs + " ]";
    }
    
}
