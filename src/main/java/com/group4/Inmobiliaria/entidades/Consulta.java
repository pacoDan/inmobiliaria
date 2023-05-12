package com.group4.Inmobiliaria.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Consulta", catalog = "inmobiliaria", schema = "")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "Id")
    private String id;
    
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "Hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    
    @Column(name = "Descripcion")
    private String descripcion;
    
    @JoinColumn(name = "Id_Emisor", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente emisor;
    
    @JoinColumn(name = "Id_Receptor", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ente receptor;
    
    @JoinColumn(name = "Id_Propiedad", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Propiedad propiedad;

}
