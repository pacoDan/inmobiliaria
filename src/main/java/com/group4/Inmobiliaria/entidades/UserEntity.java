package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.Rol;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class UserEntity {
    
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    
    @Basic(optional = false)
    @Column(name = "Rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;
    
}
