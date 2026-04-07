package com.example.consumer.user.infrastructure.event;

import com.example.consumer.user.domain.entity.User;
import com.example.consumer.user.domain.port.UserProcessedPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * ADAPTADOR DE SALIDA: UserKafkaPublisherAdapter
 * * Actúa como el puente final que envía el usuario ya procesado
 * hacia un nuevo destino en el clúster de Kafka.
 */
@Component
public class UserKafkaPublisherAdapter implements UserProcessedPort {

    // Herramienta para realizar el envío de mensajes a los tópicos
    private final KafkaTemplate<String, User> kafkaTemplate;

    // Nombre del tópico de destino
    private static final String TOPIC_PROCESSED = "ClientesProcesados";

    /**
     * Constructor para la inyección de dependencias
     */
    public UserKafkaPublisherAdapter(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Implementación del contrato de publicación procesada
     * * @param user Objeto de dominio ya transformado
     */
    @Override
    public void publishProcessed(User user) {
        // Se realiza el envío al tópico "ClientesProcesados"
        kafkaTemplate.send(TOPIC_PROCESSED, user);
    }
}