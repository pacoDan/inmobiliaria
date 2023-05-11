package com.group4.Inmobiliaria;

import com.group4.Inmobiliaria.domain.PublicacionEjemplo;
import com.group4.Inmobiliaria.repository.RepositorioDePosteos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class InmobiliariaApplication {
   static RepositorioDePosteos repositorioDePosteos;
	public static void main(String[] args) {

        SpringApplication.run(InmobiliariaApplication.class, args);
        System.out.println("Hola Mundo");
        PublicacionEjemplo ejemploPost = new PublicacionEjemplo("Casa de lujo en el lago","Casa en el lago con excelente vista, acabados de lujo a un excelente precio",1000);
        System.out.println(ejemploPost.getTitulo());
        repositorioDePosteos.crear(ejemploPost);

        repositorioDePosteos.borrar(ejemploPost);
        repositorioDePosteos.editar(ejemploPost);
        List<PublicacionEjemplo> posts=  repositorioDePosteos.obtenerPorTitulo("Casa de lujo en el lago");

       List<PublicacionEjemplo> posts2=  repositorioDePosteos.obtenerporPrecio(12000); // precio
        PublicacionEjemplo post=  repositorioDePosteos.obtenerPorId(12); // precio



	}

}
