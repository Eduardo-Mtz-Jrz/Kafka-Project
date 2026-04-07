package com.example.producer.user.domain.port;

import com.example.producer.user.domain.entity.User;

/**
 * PUERTO DE SALIDA: UserCreatedPort
 * Define el "CONTRATO" de comunicacion hacia el exterior.
 * El dominio define COMO quiere enviar la informacion, sin
 * importa QUE tecnologia se use.
 */
public interface UserCreatedPort {

    /**
     * Metodo para publicar el evento de usuario creado.
     * * @param user La entidad de dominio que contiene la información a enviar.
     * Metodo para convertir al objeto User en un JSON de Kafka.
     */
    void publish(User user);
}