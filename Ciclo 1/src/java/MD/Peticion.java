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
import javax.persistence.ManyToOne;
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
@Table(name = "peticion", catalog = "easytranslation", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peticion.findAll", query = "SELECT p FROM Peticion p")
    , @NamedQuery(name = "Peticion.findByCodigoPe", query = "SELECT p FROM Peticion p WHERE p.codigoPe = :codigoPe")
    , @NamedQuery(name = "Peticion.findByDescripcionPe", query = "SELECT p FROM Peticion p WHERE p.descripcionPe = :descripcionPe")
    , @NamedQuery(name = "Peticion.findByExtencionPe", query = "SELECT p FROM Peticion p WHERE p.extencionPe = :extencionPe")})
public class Peticion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_pe")
    private Integer codigoPe;
    @Size(max = 200)
    @Column(name = "descripcion_pe")
    private String descripcionPe;
    @Size(max = 20)
    @Column(name = "extencion_pe")
    private String extencionPe;
    @OneToMany(mappedBy = "codigoPe")
    private Collection<Usuario> usuarioCollection;
    @JoinColumn(name = "destino_pe", referencedColumnName = "abreviacion_id")
    @ManyToOne
    private Idioma destinoPe;
    @JoinColumn(name = "idi_abreviacion_id", referencedColumnName = "abreviacion_id")
    @ManyToOne
    private Idioma idiAbreviacionId;

    public Peticion() {
    }

    public Peticion(Integer codigoPe) {
        this.codigoPe = codigoPe;
    }

    public Integer getCodigoPe() {
        return codigoPe;
    }

    public void setCodigoPe(Integer codigoPe) {
        this.codigoPe = codigoPe;
    }

    public String getDescripcionPe() {
        return descripcionPe;
    }

    public void setDescripcionPe(String descripcionPe) {
        this.descripcionPe = descripcionPe;
    }

    public String getExtencionPe() {
        return extencionPe;
    }

    public void setExtencionPe(String extencionPe) {
        this.extencionPe = extencionPe;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Idioma getDestinoPe() {
        return destinoPe;
    }

    public void setDestinoPe(Idioma destinoPe) {
        this.destinoPe = destinoPe;
    }

    public Idioma getIdiAbreviacionId() {
        return idiAbreviacionId;
    }

    public void setIdiAbreviacionId(Idioma idiAbreviacionId) {
        this.idiAbreviacionId = idiAbreviacionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPe != null ? codigoPe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peticion)) {
            return false;
        }
        Peticion other = (Peticion) object;
        if ((this.codigoPe == null && other.codigoPe != null) || (this.codigoPe != null && !this.codigoPe.equals(other.codigoPe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MD.Peticion[ codigoPe=" + codigoPe + " ]";
    }
    
}
