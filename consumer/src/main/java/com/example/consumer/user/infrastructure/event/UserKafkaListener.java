package com.example.consumer.user.infrastructure.event;

import com.example.consumer.user.application.created.UserProcessService;
import com.example.consumer.user.domain.entity.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * ADAPTADOR DE ENTRADA: UserKafkaListener
 * * Su responsabilidad es "escuchar" los mensajes que llegan
 * a través de Kafka
 */
@Component
public class UserKafkaListener {

    // Inyeccion de dependencia al Caso de Uso
    private final UserProcessService userProcessService;

    /**
     * Constructor para la inyección de dependencias
     */
    public UserKafkaListener(UserProcessService userProcessService) {
        this.userProcessService = userProcessService;
    }

    /**
     * Punto de entrada del evento de Kafka.
     * * @KafkaListener: Configura este metodo para que se ejecute cada vez que llega
     * un mensaje al topic "ClientesTopic"
     * * @Payload: Indica a Spring que debe convertir el cuerpo del mensaje
     * (JSON) en nuestro objeto de dominio
     * * @param user Objeto de dominio reconstruido a partir del mensaje recibido.
     */
    @KafkaListener(topics = "ClientesTopic", groupId = "grupo-consumidor")
    public void listen(@Payload User user) {
        userProcessService.execute(user);
    }
}