package com.group4.Inmobiliaria.utils;

import com.group4.Inmobiliaria.entidades.ImagenPropiedad;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Image {

    private static String bytesToBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static List<String> getBase64Images(List<ImagenPropiedad> imagenes) {
        List<String> base64Image = new ArrayList<>();
        for (ImagenPropiedad imagen : imagenes) {
            base64Image.add(bytesToBase64(imagen.getContenido()));
        }
        return base64Image;
    }

}
