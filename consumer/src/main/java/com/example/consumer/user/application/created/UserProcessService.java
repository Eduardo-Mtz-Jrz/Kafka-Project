package com.example.consumer.user.application.created;

import com.example.consumer.user.domain.entity.User;
import com.example.consumer.user.domain.port.UserProcessedPort;
import org.springframework.stereotype.Service;

/**
 * CASO DE USO: UserProcessService
 * * Su responsabilidad es aplicar la LOGICA DE NEGOCIO sobre los datos recibidos
 * (Kafka) antes de que sigan su camino
 */
@Service
public class UserProcessService {

    // Inyección del puerto de salida
    private final UserProcessedPort userProcessedPort;

    /**
     * Constructor para la inyección de dependencias
     */
    public UserProcessService(UserProcessedPort userProcessedPort) {
        this.userProcessedPort = userProcessedPort;
    }

    /**
     * Lógica de ejecución del procesamiento.
     * * @param user Objeto de dominio que fue reconstruido desde el JSON de Kafka
     */
    public void execute(User user) {
        // Regla de negocio: Nombre a MAYÚSCULAS
        User userUpperCase = new User(
                user.nombre().toUpperCase(),
                user.email()
        );

        // Enviamos al puerto de salida
        userProcessedPort.publishProcessed(userUpperCase);

        // System.out.println("LOG: Procesado -> " + userUpperCase.nombre());
    }
}