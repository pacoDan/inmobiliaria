package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.TipoPropiedad;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Propiedad")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Propiedad implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false)
    private String id;
    
    @Basic(optional = false)
    @Column(name = "Tipo_propiedad")
    @Enumerated(EnumType.STRING)
    private TipoPropiedad tipopropiedad;
    
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
     
    @Basic(optional = false)
    @Column(name = "Precio_venta")
    private double precioventa;
    
    @Basic(optional = false)
    @Column(name = "Precio_Alquiler")
    private double precioAlquiler;
    
    @Basic(optional = false)
    @Column(name = "Imagenes")
    private String imagenes;
    
    @Basic(optional = false)
    @Column(name = "Disponible")
    private boolean disponible;
        
}
