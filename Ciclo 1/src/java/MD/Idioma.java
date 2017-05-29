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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author ALIENWARE
 */
@Entity
@Table(name = "idioma", catalog = "easytranslation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idioma.findAll", query = "SELECT i FROM Idioma i")
    , @NamedQuery(name = "Idioma.findByAbreviacionId", query = "SELECT i FROM Idioma i WHERE i.abreviacionId = :abreviacionId")
    , @NamedQuery(name = "Idioma.findByDescripcionId", query = "SELECT i FROM Idioma i WHERE i.descripcionId = :descripcionId")})
public class Idioma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "abreviacion_id")
    private String abreviacionId;
    @Size(max = 100)
    @Column(name = "descripcion_id")
    private String descripcionId;
    @JoinTable(name = "sabe", joinColumns = {
        @JoinColumn(name = "abreviacion_id", referencedColumnName = "abreviacion_id")}, inverseJoinColumns = {
        @JoinColumn(name = "correo_us", referencedColumnName = "correo_us")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @OneToMany(mappedBy = "abreviacionId")
    private Collection<Revisor> revisorCollection;
    @OneToMany(mappedBy = "destinoPe")
    private Collection<Peticion> peticionCollection;
    @OneToMany(mappedBy = "idiAbreviacionId")
    private Collection<Peticion> peticionCollection1;

    public Idioma() {
    }

    public Idioma(String abreviacionId) {
        this.abreviacionId = abreviacionId;
    }

    public String getAbreviacionId() {
        return abreviacionId;
    }

    public void setAbreviacionId(String abreviacionId) {
        this.abreviacionId = abreviacionId;
    }

    public String getDescripcionId() {
        return descripcionId;
    }

    public void setDescripcionId(String descripcionId) {
        this.descripcionId = descripcionId;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Revisor> getRevisorCollection() {
        return revisorCollection;
    }

    public void setRevisorCollection(Collection<Revisor> revisorCollection) {
        this.revisorCollection = revisorCollection;
    }

    @XmlTransient
    public Collection<Peticion> getPeticionCollection() {
        return peticionCollection;
    }

    public void setPeticionCollection(Collection<Peticion> peticionCollection) {
        this.peticionCollection = peticionCollection;
    }

    @XmlTransient
    public Collection<Peticion> getPeticionCollection1() {
        return peticionCollection1;
    }

    public void setPeticionCollection1(Collection<Peticion> peticionCollection1) {
        this.peticionCollection1 = peticionCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (abreviacionId != null ? abreviacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idioma)) {
            return false;
        }
        Idioma other = (Idioma) object;
        if ((this.abreviacionId == null && other.abreviacionId != null) || (this.abreviacionId != null && !this.abreviacionId.equals(other.abreviacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MD.Idioma[ abreviacionId=" + abreviacionId + " ]";
    }
    
}
