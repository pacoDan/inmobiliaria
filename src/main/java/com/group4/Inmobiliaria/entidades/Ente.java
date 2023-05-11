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
@Table(name = "Ente", catalog = "inmobiliaria", schema = "")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ente implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "Id")
    private String id;
    
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    
    @Column(name = "Telefono")
    private String telefono;
    
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    
    @Column(name = "Imagen_Perfil")
    private String imagenPerfil;
    
    @Basic(optional = false)
    @Column(name = "Rol")
    private String rol;
    
    @OneToMany(mappedBy = "idReceptor", fetch = FetchType.LAZY)
    private List<Cita> citasRecibidas;
    
    @OneToMany(mappedBy = "idReceptor", fetch = FetchType.LAZY)
    private List<Consulta> consultasRecibidas;
    
    @OneToMany(mappedBy = "idReceptor", fetch = FetchType.LAZY)
    private List<Reclamo> reclamosRecibidos;
    
    @OneToMany(mappedBy = "idReceptor", fetch = FetchType.LAZY)
    private List<Oferta> ofertasRecibidas;
    
    @OneToMany(mappedBy = "propietarioID", fetch = FetchType.LAZY)
    private List<Propiedad> propiedades;
    
    @OneToMany(mappedBy = "emisorId", fetch = FetchType.LAZY)
    private List<Pago> pagosEmitidos;

}
