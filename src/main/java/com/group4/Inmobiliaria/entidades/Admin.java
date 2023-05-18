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
@Table(name = "Admin")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "Id", nullable = false)
    private String id;
    
    @Basic(optional = false)
    @Column(name = "Nombre", nullable = false)
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "Apellido", nullable = false)
    private String apellido;
    
    @Basic(optional = false)
    @Column(name = "Email", nullable = false)
    private String email;
    
    @Basic(optional = false)
    @Column(name = "Telefono", nullable = false)
    private String telefono;
    
    @Basic(optional = false)
    @Column(name = "Password", nullable = false)
    private String password;
    
    @Column(name = "Imagen_Perfil")
    private String imagenPerfil;
    
    @Basic(optional = false)
    @Column(name = "Rol", nullable = false)
    @Enumerated(EnumType.STRING)
    private Rol rol;    
}
