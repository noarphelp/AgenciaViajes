<img width="1024" height="1024" alt="agenciaViajes" src="https://github.com/user-attachments/assets/dd38a646-e423-4473-9147-3c5faa33f522" />
# AgenciaViajes 🛫🏨

Una plataforma de microservicios para la gestión integral de una agencia de viajes: vuelos, hoteles y reservas, con arquitectura distribuida y orquestada.  
Ideal como proyecto de referencia educativa o base para aplicaciones reales.

---

## 📑 Tabla de contenidos

1. [Visión general](#🌍-visión-general)  
2. [Arquitectura del sistema](#🏗-arquitectura-del-sistema)  
3. [Tecnologías usadas](#⚙️-tecnologías-usadas)  
4. [Estructura del repositorio y módulos](#📂-estructura-del-repositorio-y-módulos)  
5. [Requisitos previos](#🛠-requisitos-previos)  
6. [Guía de instalación y despliegue](#🚀-guía-de-instalación-y-despliegue)  
7. [Cómo ejecutar](#▶️-cómo-ejecutar)  
8. [Endpoints y APIs](#📡-endpoints-y-apis)  
9. [Pruebas](#✅-pruebas)  
10. [Mejoras futuras](#🌱-mejoras-futuras)  
11. [Créditos](#👨‍💻-créditos)

---

## 🌍 Visión general

La aplicación **AgenciaViajes** es un sistema distribuido compuesto por microservicios dedicados a manejar diferentes dominios de negocio: **vuelos**, **hoteles** y **reservas**, todo coordinado mediante un **gateway API** y un servidor de descubrimiento de servicios (Eureka).  

Su propósito es demostrar un patrón realista de microservicios con servicios independientes que colaboran para ofrecer la funcionalidad de una agencia de viajes.

---

## 🏗 Arquitectura del sistema

- **Eureka Server / Service Discovery**: registro y descubrimiento de instancias de microservicios.  
- **Gateway**: punto de entrada (API Gateway) que enruta las peticiones hacia los servicios correspondientes.  
- **Microservicios**:  
  - Servicio **Vuelos**  
  - Servicio **Hoteles**  
  - Servicio **Reservas**  
  - Configuración centralizada mediante **ServerConfig**  
- **Vista / Frontend**: interfaz de cliente para realizar búsquedas y reservas.  
- **docker-compose** para orquestar y levantar el sistema completo localmente.

---

## ⚙️ Tecnologías usadas

- **Java / Spring Boot** (cada microservicio)  
- **Spring Cloud / Netflix OSS** (Eureka, Config Server, Gateway)  
- **Docker & Docker Compose**  
- **Bases de datos relacionales** (MySql)  
- **Thymeleaf / HTML / CSS** para la capa de presentación  

---

## 📂 Estructura del repositorio y módulos

| Módulo / Directorio | Descripción |
|---------------------|-------------|
| `EurekaServerPF` | Servidor de descubrimiento (Eureka) |
| `GatewayPF` | API Gateway que enruta peticiones al backend |
| `ServerConfigPF` | Servidor de configuración centralizada |
| `Vuelos` | Microservicio de gestión de vuelos |
| `Hoteles` | Microservicio de gestión de hoteles |
| `Reservas` | Microservicio de reservas y coordinación |
| `Vista` | Frontend / interfaz para los usuarios |
| `docker-compose.yml` | Orquestación de todos los servicios |

---

## 🛠 Requisitos previos

- **Java JDK** (versión compatible con Spring Boot usada en el proyecto)  
- **Maven** o **Gradle**  
- **Docker & Docker Compose**  
- **Git**  
-  **IDE** como IntelliJ, Eclipse o VS Code  

---

## 🚀 Guía de instalación y despliegue

1. Clona el repositorio:

   ```bash
   git clone https://github.com/noarphelp/AgenciaViajes.git
   cd AgenciaViajes
   ```

**Construye los módulos:**  

```bash
mvn clean install
```

**Levanta el sistema con Docker Compose:**  

```bash
docker-compose up --build
```

**Verifica los servicios en el dashboard de Eureka** (puerto configurado en `EurekaServerPF`).

---

## ▶️ Cómo ejecutar

- Accede al **Gateway** para consumir la API.  
- Usa la interfaz de **Vista** para consultar vuelos, hoteles y realizar reservas.  
- **El flujo es:** Frontend → Gateway → Microservicios.

---

## 📡 Endpoints y APIs

Ejemplos de endpoints (según configuración del gateway y servicios):

```http
GET /gateway/vuelos          → Listar vuelos
GET /gateway/vuelos/{id}     → Obtener datos de un vuelo
GET /gateway/hoteles         → Listar hoteles
POST /gateway/reservas       → Crear una reserva
GET /gateway/reservas/{id}   → Consultar reserva
```

⚠️ Las rutas reales están definidas en los archivos de propiedades (`servicio-*.properties`).

---

## ✅ Pruebas

- **Unitarias:** JUnit / Mockito en cada módulo.  
- **Integración:** validación del flujo entre microservicios.  
- **End-to-End:** Postman, Newman u otras herramientas de testing web.  

---

## 🌱 Mejoras futuras

- Autenticación y autorización (JWT, OAuth2).  
- Gestión de usuarios y perfiles.  
- Balanceo de carga y tolerancia a fallos (Resilience4j/Hystrix).  
- Documentación de APIs con Swagger / OpenAPI.  
- Monitorización (Actuator, Prometheus, Grafana).  
- Integración con pasarelas de pago.  
- Soporte multi-idioma y multi-moneda.  

---

## 👨‍💻 Créditos 

Proyecto desarrollado por **[@noarphelp](https://github.com/noarphelp)** como ejemplo educativo de arquitectura de microservicios.

---




  




