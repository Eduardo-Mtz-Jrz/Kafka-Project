package com.example.consumer.user.domain.port;

import com.example.consumer.user.domain.entity.User;

/**
 * PUERTO DE SALIDA: UserProcessedPort
 * * Define el contrato de salida de los datos procesados
 */
public interface UserProcessedPort {

    /**
     * Metodo para notificar que el usuario ha sido procesado exitosamente
     * * @param user Objeto de dominio con las transformaciones aplicadas
     */
    void publishProcessed(User user);
}