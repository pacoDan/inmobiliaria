package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.ImagenPerfil;
import com.group4.Inmobiliaria.entidades.ImagenPropiedad;
import com.group4.Inmobiliaria.entidades.Propiedad;
import com.group4.Inmobiliaria.enums.TipoImagenPropiedad;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.group4.Inmobiliaria.repository.ImagenPerfilRepository;
import com.group4.Inmobiliaria.repository.ImagenPropiedadRepository;
import java.util.List;

@Service
public class ImagenService {

    @Autowired
    ImagenPerfilRepository imagenPerfilRepository;

    @Autowired
    ImagenPropiedadRepository imagenPropiedadRepository;

    public ImagenPerfil guardarImagenPerfil(MultipartFile archivo) throws Exception {
        if (archivo != null) {
            try {
                ImagenPerfil imagen = new ImagenPerfil();

                imagen.setMime(archivo.getContentType());

                imagen.setContenido(archivo.getBytes());

                imagen.setNombre(archivo.getName());

                return imagenPerfilRepository.save(imagen);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public ImagenPerfil actualizarImagenPerfil(MultipartFile archivo, String id) throws Exception {
        if (archivo != null) {
            try {
                ImagenPerfil imagen = null;

                Optional<ImagenPerfil> response = imagenPerfilRepository.findById(id);

                if (response.isPresent()) {
                    imagen = response.get();

                    imagen.setMime(archivo.getContentType());

                    imagen.setContenido(archivo.getBytes());

                    imagen.setNombre(archivo.getName());

                    return imagenPerfilRepository.save(imagen);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public void guardarImagenesPropiedad(List<MultipartFile> imagenes, Propiedad propiedad) throws Exception {
        for (MultipartFile imagen : imagenes) {
            if (imagen != null) {
                try {
                    ImagenPropiedad imagenPropiedad = new ImagenPropiedad();

                    imagenPropiedad.setMime(imagen.getContentType());

                    imagenPropiedad.setContenido(imagen.getBytes());

                    imagenPropiedad.setNombre(imagen.getName());

                    imagenPropiedad.setPropiedad(propiedad);

                    imagenPropiedad.setTipoImagenPropiedad(TipoImagenPropiedad.PRINCIPAL);

                    imagenPropiedadRepository.save(imagenPropiedad);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public List<ImagenPropiedad> findImagesByPropiedadId(String id) {
        return imagenPropiedadRepository.findByPropiedad_id(id);
    }

    public ImagenPropiedad findById(String id) {
       return imagenPropiedadRepository.findById(id).orElse(null);        
    }
}
