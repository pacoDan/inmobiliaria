package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.EstadoPago;
import com.group4.Inmobiliaria.enums.TipoPago;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Pago")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pago implements Serializable {
    
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false)
    private String id;
    
    @Basic(optional = false)
    @Column(name = "Monto")
    private double monto;
    
    @Basic(optional = false)
    @Column(name = "Tipo_pago")
    @Enumerated(EnumType.STRING)
    private TipoPago tipopago;
    
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
    @Enumerated(EnumType.STRING)
    private EstadoPago estadopago;
    
    @JoinColumn(name = "Emisor_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ente emisorId;
    
    @JoinColumn(name = "Receptor_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente receptorId;
    
    @JoinColumn(name = "Propiedad_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Propiedad propiedadId;

}
