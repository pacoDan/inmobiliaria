package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.EstadoPago;
import com.group4.Inmobiliaria.enums.TipoPago;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Pago")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pago extends Procedimiento implements Serializable {

    @Basic(optional = false)
    @Column(name = "Monto")
    private double monto;

    @Basic(optional = false)
    @Column(name = "Tipo_pago")
    @Enumerated(EnumType.STRING)
    private TipoPago tipopago;

    @Basic(optional = false)
    @Column(name = "Fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechavencimiento;

    @Basic(optional = false)
    @Column(name = "Estado_pago")
    @Enumerated(EnumType.STRING)
    private EstadoPago estadopago;

}
