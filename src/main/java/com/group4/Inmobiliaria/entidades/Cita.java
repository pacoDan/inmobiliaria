package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.EstadoCita;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.group4.Inmobiliaria.enums.HoraCita;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cita")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cita extends Procedimiento implements Serializable {

    @Basic(optional = false)
    @Column(name = "Estado_Cita")
    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    @Basic(optional = false)
    @Column(name = "Fecha_cita")
    private String diaCita;

    @Basic(optional = false)
    @Column(name = "Hora_Cita")
    @Enumerated(EnumType.STRING)
    private HoraCita horaCita;

}
