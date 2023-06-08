package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.TipoProcedimiento;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Procedimiento")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@ToString
public abstract class Procedimiento implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "Id", nullable = false)
    private String id;

    @Basic(optional = false)
    @Column(name = "Fecha_Emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;

    @Basic(optional = false)
    @Column(name = "Hora")
    @Temporal(TemporalType.TIME)
    private Date horaEmision;
    
    @Basic(optional = false)
    @Column(name = "Tipo_Procedimiento")
    @Enumerated(EnumType.STRING)
    private TipoProcedimiento tipoProcedimiento;

    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descripcion;   

    @JoinColumn(name = "Id_Emisor", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente emisor;

    @JoinColumn(name = "Id_Receptor", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ente receptor;

    @JoinColumn(name = "Id_Propiedad", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Propiedad propiedad;
}
