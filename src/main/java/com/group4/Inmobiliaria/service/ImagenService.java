package com.group4.Inmobiliaria.service;

import com.group4.Inmobiliaria.entidades.Imagen;
import com.group4.Inmobiliaria.enums.TipoImagen;
import com.group4.Inmobiliaria.repository.ImagenRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenService {

    @Autowired
    ImagenRepository imagenRepository;

    public Imagen guardarImagen(MultipartFile archivo, TipoImagen tipo) throws Exception {
        if (archivo != null) {
            try {
                Imagen imagen = new Imagen();
                
                imagen.setMime(archivo.getContentType());

                imagen.setContenido(archivo.getBytes());

                imagen.setNombre(archivo.getName());
                
                imagen.setTipoImagen(tipo);

                return imagenRepository.save(imagen);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public Imagen actualizarImagen(MultipartFile archivo, String id) throws Exception {
        if (archivo != null) {
            try {
                Imagen imagen = null;

                Optional<Imagen> response = imagenRepository.findById(id);

                if (response.isPresent()) {
                    imagen = response.get();

                    imagen.setMime(archivo.getContentType());

                    imagen.setContenido(archivo.getBytes());

                    imagen.setNombre(archivo.getName());

                    return imagenRepository.save(imagen);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
