package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.EstadoCita;
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
@Table(name = "Cita")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cita implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false)
    private String id;
    
    @Basic(optional = false)
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Basic(optional = false)
    @Column(name = "Hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    
    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @Column(name = "Estado")
    @Enumerated(EnumType.STRING)
    private EstadoCita estado;
    
    @JoinColumn(name = "Id_Emisor", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente idEmisor;
    
    @JoinColumn(name = "Id_Receptor", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ente idReceptor;
    
    @JoinColumn(name = "Id_Propiedad", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Propiedad idPropiedad;   

}
