package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.Rol;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Ente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ente implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false)
    private String id;
    
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "Telefono")
    private String telefono;
    
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    
    @Column(name = "Imagen_Perfil")
    private String imagenPerfil;
    
    @Basic(optional = false)
    @Column(name = "Rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;
    
}
