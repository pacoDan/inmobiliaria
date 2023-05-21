package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.TipoEnte;
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
@Table(name = "Ente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Ente extends Usuario implements Serializable {

    @Basic(optional = false)
    @Column(name = "Tipo_Ente")
    @Enumerated(EnumType.STRING)
    private TipoEnte tipoEnte;

}
