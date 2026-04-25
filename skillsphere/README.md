# SkillSphere - Backend 🚀

SkillSphere es el motor central de una plataforma integral diseñada para conectar el talento estudiantil con oportunidades académicas y laborales. Este backend, construido con **Spring Boot**, proporciona una API robusta para gestionar perfiles, certificados, instituciones y ofertas de empleo.

## 📋 Descripción del Proyecto

El objetivo de SkillSphere es centralizar la información académica y profesional de los estudiantes, permitiendo que las instituciones validen competencias a través de certificados digitales y que las empresas encuentren candidatos calificados de manera eficiente.

## 🛠️ Tecnologías y Herramientas

- **Java 21**: Lenguaje de programación principal.
- **Spring Boot 3.3.4**: Framework base para el desarrollo de microservicios.
- **Spring Data JPA**: Abstracción de persistencia de datos.
- **PostgreSQL**: Sistema de gestión de base de datos relacional.
- **Maven**: Herramienta de gestión de dependencias y construcción.
- **Lombok**: Biblioteca para reducir el código repetitivo (Boilerplate).
- **Spring Web**: Para la creación de servicios RESTful.

## 📁 Estructura del Proyecto

El backend está organizado siguiendo los estándares de Spring Boot:

- `com.grupo10.skillsphere.model`: Entidades que representan las tablas en la base de datos.
- `com.grupo10.skillsphere.repository`: Interfaces para realizar operaciones CRUD.
- `com.grupo10.skillsphere.service`: Lógica de negocio y servicios intermedios.
- `com.grupo10.skillsphere.controller`: Endpoints de la API REST.

## ⚙️ Configuración del Entorno

### Requisitos Previos
- **JDK 21** instalado.
- **PostgreSQL** instalado y en ejecución.
- **Maven** instalado (opcional, se incluye `mvnw`).

### Pasos para Ejecutar
1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/luisausuga404/proyecto_integrador_backend2.git
   cd skillsphere
   ```

2. **Configurar la Base de Datos:**
   - Crea una base de datos llamada `skillsphere_db` en PostgreSQL.
   - Ajusta el archivo `src/main/resources/application.properties` con tus credenciales:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/skillsphere_db
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     ```

3. **Ejecutar la Aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```
   La API estará disponible en `http://localhost:8080`.

## 📌 Endpoints Principales

La API ofrece los siguientes recursos principales:

- **Estudiantes (`/api/students`):** Registro, actualización y consulta de perfiles de alumnos.
- **Instituciones (`/api/institutions`):** Gestión de entidades educativas y empresas.
- **Certificados (`/api/certificates`):** Emisión y vinculación de logros académicos.
- **Ofertas Laborales (`/api/job-offers`):** Publicación y búsqueda de vacantes.

## 🤝 Contribuidores

Este proyecto es desarrollado por el **Grupo luisa-andre** como parte de su proyecto integrador.

---
⭐ **SkillSphere** - Impulsando el futuro profesional.
