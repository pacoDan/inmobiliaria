package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.TipoCliente;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Cliente extends Usuario implements Serializable {

    @Basic(optional = false)
    @Column(name = "Apellido")
    private String apellido;

    @Basic(optional = false)
    @Column(name = "DNI")
    private String DNI;

    @Basic(optional = false)
    @Column(name = "Tipo_Cliente")
    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

}
