package com.group4.Inmobiliaria.entidades;

import com.group4.Inmobiliaria.enums.Rol;
import com.group4.Inmobiliaria.enums.TipoCliente;
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
@Table(name = "Cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente extends UserEntity implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false)
    private String id;
    
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "Apellido")
    private String apellido;
    
    @Basic(optional = false)
    @Column(name = "DNI")
    private String dni;  
    
    @Basic(optional = false)
    @Column(name = "Telefono")
    private String telefono;
    
    @Basic(optional = false)
    @Column(name = "Imagen_Perfil")
    private String imagenPerfil;
    
    @Basic(optional = false)
    @Column(name = "Tipo_Cliente")
    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;
    
}
