package com.group4.Inmobiliaria.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Consulta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Consulta extends Procedimiento implements Serializable {

    @Basic(optional = false)
    @Column(name = "Asunto")
    private String asunto;

}
