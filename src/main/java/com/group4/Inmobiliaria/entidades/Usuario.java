package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.Rol;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

@Entity(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@ToString
public abstract class Usuario implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false)
    private String id;

    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "Email")
    private String email;

    @Basic(optional = false)
    @Column(name = "Password")
    private String password;

    @Basic(optional = false)  
    @OneToOne()
    @JoinColumn(name = "imagen_perfil_id")
    private Imagen imagenPerfil;

    @Basic(optional = false)
    @Column(name = "Telefono")
    private String telefono;

    @Basic(optional = false)
    @Column(name = "Rol")
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Basic(optional = false)
    @Column(name = "Fecha_Registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @Transient
    private MultipartFile archivoImagen;
}
