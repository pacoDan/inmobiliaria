package com.group4.Inmobiliaria.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Propiedad", catalog = "inmobiliaria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Propiedad.findAll", query = "SELECT p FROM Propiedad p")})
public class Propiedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Basic(optional = false)
    @Column(name = "Tipo_propiedad")
    private String tipopropiedad;
    @Basic(optional = false)
    @Column(name = "Ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "Provincia")
    private String provincia;
    @Basic(optional = false)
    @Column(name = "Pais")
    private String pais;
    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "Caracteristicas")
    private String caracteristicas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Precio_venta")
    private BigDecimal precioventa;
    @Basic(optional = false)
    @Column(name = "Precio_Alquiler")
    private BigDecimal precioAlquiler;
    @Basic(optional = false)
    @Column(name = "Imagenes")
    private String imagenes;
    @Basic(optional = false)
    @Column(name = "Disponible")
    private boolean disponible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad", fetch = FetchType.LAZY)
    private List<Cita> citaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad", fetch = FetchType.LAZY)
    private List<Consulta> consultaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propiedadId", fetch = FetchType.LAZY)
    private List<Reclamo> reclamoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPropiedad", fetch = FetchType.LAZY)
    private List<Oferta> ofertaList;
    @JoinColumn(name = "Propietario_ID", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ente propietarioID;
    @JoinColumn(name = "Inquilino_ID", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente inquilinoID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propiedadId", fetch = FetchType.LAZY)
    private List<Pago> pagoList;

    public Propiedad() {
    }

    public Propiedad(String id) {
        this.id = id;
    }

    public Propiedad(String id, String tipopropiedad, String ciudad, String provincia, String pais, String descripcion, String caracteristicas, BigDecimal precioventa, BigDecimal precioAlquiler, String imagenes, boolean disponible) {
        this.id = id;
        this.tipopropiedad = tipopropiedad;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.precioventa = precioventa;
        this.precioAlquiler = precioAlquiler;
        this.imagenes = imagenes;
        this.disponible = disponible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipopropiedad() {
        return tipopropiedad;
    }

    public void setTipopropiedad(String tipopropiedad) {
        this.tipopropiedad = tipopropiedad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public BigDecimal getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(BigDecimal precioventa) {
        this.precioventa = precioventa;
    }

    public BigDecimal getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(BigDecimal precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }

    public List<Reclamo> getReclamoList() {
        return reclamoList;
    }

    public void setReclamoList(List<Reclamo> reclamoList) {
        this.reclamoList = reclamoList;
    }

    public List<Oferta> getOfertaList() {
        return ofertaList;
    }

    public void setOfertaList(List<Oferta> ofertaList) {
        this.ofertaList = ofertaList;
    }

    public Ente getPropietarioID() {
        return propietarioID;
    }

    public void setPropietarioID(Ente propietarioID) {
        this.propietarioID = propietarioID;
    }

    public Cliente getInquilinoID() {
        return inquilinoID;
    }

    public void setInquilinoID(Cliente inquilinoID) {
        this.inquilinoID = inquilinoID;
    }

    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
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
        if (!(object instanceof Propiedad)) {
            return false;
        }
        Propiedad other = (Propiedad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group4.Inmobiliaria.entidades.Propiedad[ id=" + id + " ]";
    }

}
