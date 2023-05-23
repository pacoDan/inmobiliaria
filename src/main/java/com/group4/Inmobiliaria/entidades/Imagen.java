package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.TipoImagen;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Imagenes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Imagen {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "Id", nullable = false)
    private String id;
    
    @Basic(optional = false)
    @Column(name = "Mime")   
    private String mime;

    @Basic(optional = false)
    @Column(name = "Tipo_Imagen")
    @Enumerated(EnumType.STRING)
    private TipoImagen tipoImagen;
    
    @Basic(optional = false)
    @Column(name = "Nombre")   
    private String nombre;
    
    @Basic(optional = false, fetch = FetchType.LAZY)
    @Column(name = "Contenido")    
    @Lob
    private byte[] contenido;
}
