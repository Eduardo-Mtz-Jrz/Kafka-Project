package com.example.producer.user.infrastructure.api;

import com.example.producer.user.application.created.UserCreateService;
import com.example.producer.user.domain.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ADAPTADOR DE ENTRADA: UserController
 * * Actua como un punto de entrada para clientes externos (Postman)
 * * Su responsabilidad es recibir peticiones HTTP, mapearlas a objetos de dominio
 * y delegar la ejecución al Caso de Uso
 */
@RestController
@RequestMapping("/api/clients")
public class UserController {

    // Inyección del Caso de Uso (Service)
    private final UserCreateService userCreateService;

    /**
     * Constructor para la inyeccion de dependencias
     */
    public UserController(UserCreateService userCreateService) {
        this.userCreateService = userCreateService;
    }

    /**
     * Endpoint para la creacion de usuarios.
     * * Recibe un objeto JSON en el cuerpo de la petición y lo convierte automáticamente
     * en el record del dominio
     * * @param user Objeto de dominio mapeado desde el JSON recibido.
     * * @return Una respuesta HTTP 200 (OK) con el mensaje de confirmación del servicio.
     */
    @PostMapping
    public ResponseEntity<String> create(@RequestBody User user) {

        // Se llama al metodo 'execute' del caso de uso para iniciar el flujo de negocio
        return ResponseEntity.ok(userCreateService.execute(user));
    }
}