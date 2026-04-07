package com.example.consumer.user.domain.entity;

/**
 * ENTIDAD DE DOMINIO: User
 * * Modelo de datos interno del Microservicio
 * * Se utiliza un 'record' para garantizar la inmutabilidad
 */
public record User(String nombre, String email) {
}
