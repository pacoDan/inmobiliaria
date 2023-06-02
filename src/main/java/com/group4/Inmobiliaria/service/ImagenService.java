package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.ImagenPerfil;
import com.group4.Inmobiliaria.entidades.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.group4.Inmobiliaria.repository.ImagenPerfilRepository;

@Service
public class ImagenService {

    @Autowired
    ImagenPerfilRepository imagenPerfilRepository;

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

    public ImagenPerfil actualizarImagen(MultipartFile archivo, String id) throws Exception {
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
}
