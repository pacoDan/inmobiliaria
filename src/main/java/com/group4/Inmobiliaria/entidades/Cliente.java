package com.group4.Inmobiliaria.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Cliente", catalog = "inmobiliaria", schema = "")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "Id")
    private String id;
    
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "Apellido")
    private String apellido;
    
    @Column(name = "DNI")
    private String dni;
    
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    
    @Column(name = "Telefono")
    private String telefono;
    
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    
    @Column(name = "Imagen_Perfil")
    private String imagenPerfil;
    
    @Basic(optional = false)
    @Column(name = "Rol")
    private String rol;
    
    @OneToMany(mappedBy = "idEmisor", fetch = FetchType.LAZY)
    private List<Cita> citasRealizadas;
    
    @OneToMany(mappedBy = "idEmisor", fetch = FetchType.LAZY)
    private List<Consulta> consultasRealizadas;
    
    @OneToMany(mappedBy = "idEmisor", fetch = FetchType.LAZY)
    private List<Reclamo> reclamosRealizados;
    
    @OneToMany(mappedBy = "idEmisor", fetch = FetchType.LAZY)
    private List<Oferta> ofertasRealizadas;
    
    @OneToMany(mappedBy = "inquilinoID", fetch = FetchType.LAZY)
    private List<Propiedad> propiedades;
    
    @OneToMany(mappedBy = "receptorId", fetch = FetchType.LAZY)
    private List<Pago> pagos;

    

}
