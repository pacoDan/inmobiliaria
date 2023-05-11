package com.group4.Inmobiliaria.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Propiedad", catalog = "inmobiliaria", schema = "")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Propiedad implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
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
    
    @Column(name = "Descripcion")
    private String descripcion;
    
    @Column(name = "Caracteristicas")
    private String caracteristicas;   
    
    @Column(name = "Precio_venta")
    private double precioVenta;
    
    @Column(name = "Precio_Alquiler")
    private double precioAlquiler;
    
    @Column(name = "Imagenes")
    private String imagenes;
    
    @Column(name = "Disponible")
    private Boolean disponible;
    
    @JoinColumn(name = "Propietario_ID", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ente propietario;
    
    @JoinColumn(name = "Inquilino_ID", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente inquilino;

    
}
