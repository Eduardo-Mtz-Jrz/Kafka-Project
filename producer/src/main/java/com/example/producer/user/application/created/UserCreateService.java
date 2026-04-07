package com.example.producer.user.application.created;

import com.example.producer.user.domain.entity.User;
import com.example.producer.user.domain.port.UserCreatedPort;
import org.springframework.stereotype.Service;

/**
 * CASO DE USO: UserCreateService
 * * Su responsabilidad es la logica para "Crear un Usuario"
 * dentro del del microservicio
 * * No contiene logica de infraestructura (no sabe que es Kafka),
 * solo sabe que debe usar un "Puerto" para cumplir su objetivo
 */
@Service
public class UserCreateService {

    // Inyeccion del puerto de salida
    private final UserCreatedPort userCreatedPort;

    /**
     * Constructor para inyeccion de dependencias
     */
    public UserCreateService(UserCreatedPort userCreatedPort) {
        this.userCreatedPort = userCreatedPort;
    }

    /**
     * Lógica de ejecucion
     * * @param user Entidad de dominio recibida
     * * @return Mensaje de confirmacion de la operacion.
     */
    public String execute(User user) {

        // Se delega al puerto la publicación del evento
        userCreatedPort.publish(user);

        // Retorna una respuesta de exito
        return "Enviado a Kafka";
    }
}