package com.group4.Inmobiliaria.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group4.Inmobiliaria.enums.TipoPropiedad;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Propiedad")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Propiedad implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false)    
    private String id;

    @Basic(optional = false)
    @Column(name = "Tipo_propiedad")
    @Enumerated(EnumType.STRING)
    private TipoPropiedad tipoPropiedad;

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

    @JoinColumn(name = "Id_Propietario", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    private Ente propietario;

    @JoinColumn(name = "Id_Inquilino", referencedColumnName = "Id", nullable = true)
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private Cliente inquilino;

    @Basic(optional = false)
    @Column(name = "Precio_venta")
    private double precioVenta;

    @Basic(optional = false)
    @Column(name = "Precio_Alquiler")
    private double precioAlquiler;

    @Basic(optional = false)
    @Column(name = "Disponible")
    private boolean disponible;
    
    @OneToMany(mappedBy = "propiedad", fetch = FetchType.EAGER)
    private List<ImagenPropiedad> imagenes;

    @Transient
    private List<MultipartFile> imagenesFiles;
}
