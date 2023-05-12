package com.group4.Inmobiliaria.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Pago", catalog = "inmobiliaria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @Column(name = "Tipo_pago")
    private String tipopago;
    @Basic(optional = false)
    @Column(name = "Fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaemision;
    @Basic(optional = false)
    @Column(name = "Fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechavencimiento;
    @Basic(optional = false)
    @Column(name = "Estado_pago")
    private String estadopago;
    @JoinColumn(name = "Emisor_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ente emisorId;
    @JoinColumn(name = "Receptor_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente receptorId;
    @JoinColumn(name = "Propiedad_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Propiedad propiedadId;

    public Pago() {
    }

    public Pago(String id) {
        this.id = id;
    }

    public Pago(String id, BigDecimal monto, String tipopago, Date fechaemision, Date fechavencimiento, String estadopago) {
        this.id = id;
        this.monto = monto;
        this.tipopago = tipopago;
        this.fechaemision = fechaemision;
        this.fechavencimiento = fechavencimiento;
        this.estadopago = estadopago;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public Date getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(Date fechaemision) {
        this.fechaemision = fechaemision;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public String getEstadopago() {
        return estadopago;
    }

    public void setEstadopago(String estadopago) {
        this.estadopago = estadopago;
    }

    public Ente getEmisorId() {
        return emisorId;
    }

    public void setEmisorId(Ente emisorId) {
        this.emisorId = emisorId;
    }

    public Cliente getReceptorId() {
        return receptorId;
    }

    public void setReceptorId(Cliente receptorId) {
        this.receptorId = receptorId;
    }

    public Propiedad getPropiedadId() {
        return propiedadId;
    }

    public void setPropiedadId(Propiedad propiedadId) {
        this.propiedadId = propiedadId;
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
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group4.Inmobiliaria.entidades.Pago[ id=" + id + " ]";
    }

}
