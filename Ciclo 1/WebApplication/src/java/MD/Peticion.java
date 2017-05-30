/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALIENWARE
 */
@Entity
@Table(name = "PETICION", catalog = "", schema = "EASYTRANSLATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peticion.findAll", query = "SELECT p FROM Peticion p")
    , @NamedQuery(name = "Peticion.findByCodigoPe", query = "SELECT p FROM Peticion p WHERE p.codigoPe = :codigoPe")
    , @NamedQuery(name = "Peticion.findByTipoPe", query = "SELECT p FROM Peticion p WHERE p.tipoPe = :tipoPe")
    , @NamedQuery(name = "Peticion.findByFechaEmisionPe", query = "SELECT p FROM Peticion p WHERE p.fechaEmisionPe = :fechaEmisionPe")
    , @NamedQuery(name = "Peticion.findByEstadoPe", query = "SELECT p FROM Peticion p WHERE p.estadoPe = :estadoPe")})
public class Peticion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PE")
    private BigDecimal codigoPe;
    @Lob
    @Column(name = "DESCRIPCION_PE")
    private String descripcionPe;
    @Size(max = 10)
    @Column(name = "TIPO_PE")
    private String tipoPe;
    @Column(name = "FECHA_EMISION_PE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmisionPe;
    @Size(max = 15)
    @Column(name = "ESTADO_PE")
    private String estadoPe;
    @JoinColumn(name = "ABREVIACION_ID", referencedColumnName = "ABREVIACION_ID")
    @ManyToOne
    private Idioma abreviacionId;
    @JoinColumn(name = "IDI_ABREVIACION_ID", referencedColumnName = "ABREVIACION_ID")
    @ManyToOne
    private Idioma idiAbreviacionId;
    @JoinColumn(name = "CORREO_US", referencedColumnName = "CORREO_US")
    @ManyToOne
    private Usuario correoUs;

    public Peticion() {
    }

    public Peticion(BigDecimal codigoPe) {
        this.codigoPe = codigoPe;
    }

    public BigDecimal getCodigoPe() {
        return codigoPe;
    }

    public void setCodigoPe(BigDecimal codigoPe) {
        this.codigoPe = codigoPe;
    }

    public String getDescripcionPe() {
        return descripcionPe;
    }

    public void setDescripcionPe(String descripcionPe) {
        this.descripcionPe = descripcionPe;
    }

    public String getTipoPe() {
        return tipoPe;
    }

    public void setTipoPe(String tipoPe) {
        this.tipoPe = tipoPe;
    }

    public Date getFechaEmisionPe() {
        return fechaEmisionPe;
    }

    public void setFechaEmisionPe(Date fechaEmisionPe) {
        this.fechaEmisionPe = fechaEmisionPe;
    }

    public String getEstadoPe() {
        return estadoPe;
    }

    public void setEstadoPe(String estadoPe) {
        this.estadoPe = estadoPe;
    }

    public Idioma getAbreviacionId() {
        return abreviacionId;
    }

    public void setAbreviacionId(Idioma abreviacionId) {
        this.abreviacionId = abreviacionId;
    }

    public Idioma getIdiAbreviacionId() {
        return idiAbreviacionId;
    }

    public void setIdiAbreviacionId(Idioma idiAbreviacionId) {
        this.idiAbreviacionId = idiAbreviacionId;
    }

    public Usuario getCorreoUs() {
        return correoUs;
    }

    public void setCorreoUs(Usuario correoUs) {
        this.correoUs = correoUs;
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
