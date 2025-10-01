<img width="1024" height="1024" alt="agenciaViajes" src="https://github.com/user-attachments/assets/dd38a646-e423-4473-9147-3c5faa33f522" />

AgenciaViajes 🛫🏨

Una plataforma microservicios para la gestión integral de una agencia de viajes: vuelos, hoteles y reservas, con arquitectura distribuida y orquestada, ideal como proyecto de referencia educativa o base para aplicaciones reales.

Tabla de contenidos

Visión general

Arquitectura del sistema

Tecnologías usadas

Estructura del repositorio y módulos

Requisitos previos

Guía de instalación y despliegue

Cómo ejecutar

Endpoints y APIs

Pruebas

Mejoras futuras

Créditos

Licencia

Visión general

La aplicación AgenciaViajes es un sistema distribuido compuesto por microservicios dedicados a manejar diferentes dominios de negocio: vuelos, hoteles y reservas, todo coordinado mediante un gateway API y descubrimiento de servicios (Eureka).
La idea es demostrar un patrón realista de microservicios con servicios independientes que colaboran para ofrecer la funcionalidad de una agencia de viajes.

Arquitectura del sistema

Eureka Server / Service Discovery: Registro y descubrimiento de instancias de microservicios.

Gateway: Punto de entrada (API Gateway) que enruta las peticiones hacia los servicios correspondientes.

Microservicios:

Servicio Vuelos

Servicio Hoteles

Servicio Reservas

Configuración centralizada mediante ServerConfig

docker-compose para orquestar y levantar el sistema completo localmente.

El uso de configuración centralizada y descubrimiento de servicios contribuye con escalabilidad, tolerancia a fallos y desacoplamiento entre componentes.

Tecnologías usadas

Java / Spring Boot (para cada microservicio)

Spring Cloud / Netflix OSS (Eureka, Config Server, Gateway)

Docker / Docker Compose

Base de datos (MySql)

HTML / Thymeleaf / (u otro framework de vistas) para la capa de presentación

Propiedades externas para configurar rutas, puertos y endpoints

Estructura del repositorio y módulos

Aquí un resumen de los módulos/directorios más relevantes:

Módulo / Directorio	Descripción
EurekaServerPF	Servidor de descubrimiento (Eureka)
GatewayPF	API Gateway que enruta peticiones al backend
ServerConfigPF	Servidor de configuración centralizada
Vuelos	Microservicio de gestión de vuelos
Hoteles	Microservicio de gestión de hoteles
Reservas	Microservicio de reservas y coordinación entre vuelos y hoteles
Vista	Frontend / interfaz para los usuarios
docker-compose.yml	Archivo para orquestar todos los servicios junto con configuración

También hay archivos de propiedades para cada servicio (servicio-*.properties) para definir puertos, rutas, configuración de comunicación, etc.

Requisitos previos

Antes de comenzar, asegúrate de tener instalados:

Java JDK (versión compatible con Spring Boot usada)

Maven o Gradle (según proyecto)

Docker & Docker Compose

Git

 IDE como IntelliJ, Eclipse o VS Code

Guía de instalación y despliegue

Clona el repositorio:

git clone https://github.com/noarphelp/AgenciaViajes.git
cd AgenciaViajes


Construye los módulos (por ejemplo, usando Maven):

mvn clean install


Levanta el sistema completo utilizando Docker Compose:

docker-compose up --build


Esto iniciará Eureka, Gateway, config server y todos los microservicios.

Verifica que todos los servicios estén “UP” consultando el dashboard de Eureka (usualmente en algún puerto configurado en EurekaServerPF).

Cómo ejecutar

Accede al Gateway para consumir la API.

La interfaz del frontend (Vista) te permitirá buscar vuelos, hoteles y crear reservas.

Las peticiones desde el frontend viajan al gateway, que las envía al microservicio correspondiente.

Cada microservicio puede tener sus propios endpoints REST para listados, búsquedas, CRUD, etc.

Endpoints y APIs

Aquí un ejemplo de algunos endpoints que podría ofrecer el sistema (revisa los archivos de propiedades y controladores del proyecto para confirmación):

GET /gateway/vuelos – Listar vuelos

GET /gateway/vuelos/{id} – Obtener datos de un vuelo específico

GET /gateway/hoteles – Listar hoteles

POST /gateway/reservas – Crear una reserva

GET /gateway/reservas/{id} – Obtener reserva por ID

⚠️ Ten en cuenta que las rutas reales están definidas en los archivos de propiedades y el gateway, así que revisa servicio-gateway.properties, servicio-vuelos.properties, etc.

Pruebas

Puedes crear pruebas unitarias con JUnit / Mockito dentro de cada módulo.

También es bueno incluir pruebas de integración para validar el flujo completo (frontend → gateway → backend).

(Opcional) pruebas end-to-end usando herramientas como Postman, Newman o frameworks de testing web.

Mejora futura (Roadmap)

Algunas ideas que podrían integrarse para seguir evolucionando el proyecto:

Autenticación / autorización (OAuth2, JWT)

Gestión de usuarios (registro, perfiles)

Caching / balanceo de carga

Circuit Breaker / resiliencia (Hystrix, Resilience4j)

Monitorización (Spring Boot Actuator, Prometheus, Grafana)

Documentación de API con Swagger / OpenAPI

Integración con pasarelas de pago

Soporte para múltiples monedas e idiomas


Créditos

Proyecto desarrollado por noarphelp  como ejercicio de arquitectura de microservicios.

