package com.group4.Inmobiliaria.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Pago", catalog = "inmobiliaria", schema = "")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pago implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "Id")
    private String id;
        
    @Basic(optional = false)
    @Column(name = "Monto")
    private double monto;
    
    @Basic(optional = false)
    @Column(name = "Tipo_pago")
    private String tipoPago;
    
    @Column(name = "Fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    
    @Column(name = "Fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    
    @Basic(optional = false)
    @Column(name = "Estado_pago")
    private String estadoPago;
    
    @JoinColumn(name = "Emisor_Id", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ente emisor;
    
    @JoinColumn(name = "Receptor_Id", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente receptor;
    
    @JoinColumn(name = "Id_Propiedad", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Propiedad propiedad;


}
