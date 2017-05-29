/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ALIENWARE
 */
@Entity
@Table(name = "usuario", catalog = "easytranslation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCorreoUs", query = "SELECT u FROM Usuario u WHERE u.correoUs = :correoUs")
    , @NamedQuery(name = "Usuario.findByNombreUs", query = "SELECT u FROM Usuario u WHERE u.nombreUs = :nombreUs")
    , @NamedQuery(name = "Usuario.findByContrasenaUs", query = "SELECT u FROM Usuario u WHERE u.contrasenaUs = :contrasenaUs")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo_us")
    private String correoUs;
    @Size(max = 200)
    @Column(name = "nombre_us")
    private String nombreUs;
    @Size(max = 40)
    @Column(name = "contrasena_us")
    private String contrasenaUs;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Idioma> idiomaCollection;
    @JoinColumn(name = "codigo_pe", referencedColumnName = "codigo_pe")
    @ManyToOne
    private Peticion codigoPe;

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

    public String getContrasenaUs() {
        return contrasenaUs;
    }

    public void setContrasenaUs(String contrasenaUs) {
        this.contrasenaUs = contrasenaUs;
    }

    @XmlTransient
    public Collection<Idioma> getIdiomaCollection() {
        return idiomaCollection;
    }

    public void setIdiomaCollection(Collection<Idioma> idiomaCollection) {
        this.idiomaCollection = idiomaCollection;
    }

    public Peticion getCodigoPe() {
        return codigoPe;
    }

    public void setCodigoPe(Peticion codigoPe) {
        this.codigoPe = codigoPe;
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
