# Kafka-Project 🚀
Este proyecto es un ecosistema de prueba diseñado para demostrar la comunicación asíncrona entre microservicios utilizando Apache Kafka como broker de mensajería.

## 📌 Arquitectura del Proyecto
* El sistema se divide en dos componentes principales desarrollados con Java 21 y Spring Boot 3:
* MS Producer: Se encarga de captar eventos de usuario y publicarlos en un tópico específico de Kafka.
* MS Consumer: Escucha activamente el tópico, procesa los mensajes entrantes y gestiona la lógica de negocio correspondiente.

## 🛠️ Tecnologías Utilizadas
* Java 21 (LTS)
* Spring Boot
* Apache Kafka (Messaging Broker)
* Docker & Docker Compose (Containerization)
* Maven
