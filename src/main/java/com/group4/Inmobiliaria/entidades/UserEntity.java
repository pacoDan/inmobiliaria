package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.Rol;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
@Getter
@Setter
@ToString
public abstract class UserEntity {
    
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false)
    private String id;
    
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
