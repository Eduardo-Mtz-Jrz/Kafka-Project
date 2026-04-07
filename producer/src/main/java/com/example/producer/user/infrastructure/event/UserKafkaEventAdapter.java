package com.example.producer.user.infrastructure.event;

import com.example.producer.user.domain.entity.User;
import com.example.producer.user.domain.port.UserCreatedPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * ADAPTADOR DE SALIDA: UserKafkaEventAdapter
 * * Su funcion es implementar el Puerto de Salida definido en el dominio
 */
@Component
public class UserKafkaEventAdapter implements UserCreatedPort {

    // Herramienta de Spring Kafka para enviar mensajes al cluster
    private final KafkaTemplate<String, User> kafkaTemplate;

    // Nombre del topic al que se enviarán los eventos
    private static final String TOPIC = "ClientesTopic";

    /**
     * Constructor para la inyección de dependencias
     */
    public UserKafkaEventAdapter(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Implementacion del contrato de publicación del dominio.
     * * Este metodo convierte el objeto de dominio en un mensaje de Kafka
     * * @param user Entidad de dominio que se desea publicar
     */
    @Override
    public void publish(User user) {

        // Envía el objeto al topic definido
        kafkaTemplate.send(TOPIC, user);
    }
}