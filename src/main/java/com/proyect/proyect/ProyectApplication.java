package com.proyect.proyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProyectApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ProyectApplication.class, args);
	}

	// @GetMapping("/")
	// public Message newmessage(){
	// return new Message(LocalDateTime.now(), "Hola mundooooooooo desde sprint");
	// }
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:3003") // Permitir solicitudes desde este origen
				.allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
				.allowedHeaders("*"); // Encabezados permitidos
	}

}
