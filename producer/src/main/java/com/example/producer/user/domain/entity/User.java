package com.example.producer.user.domain.entity;

/**
 * ENTIDAD DE DOMINIO: User
 * Objeto inmutable (Record) que define datos necesarios para identificar a un user.
 */
public record User(String nombre, String email) {
}