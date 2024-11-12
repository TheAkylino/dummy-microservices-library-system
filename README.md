# Sistema de Biblioteca
*Recto Técnico Sistema de Biblioteca Arquitectura de Microservicios* 
-------------------------------------------------------------------------
*Arquitectura de Capas (Layered Architecture) en Microservicios*

1. Capa de Controladores:
* Maneja las solicitudes y respuestas HTTP.
* Realiza la validación inicial y convierte las solicitudes en llamadas a servicios

2. Capa de Servicios:
* Contiene la lógica de negocio.
* Realiza el procesamiento de datos, aplica reglas de negocio y coordina la interacción entre las diferentes capas.

3. Capa de Repositorios:
* Maneja la persistencia de datos
* Interactúa con la base de datos y proporciona métodos para acceder y manipular datos.

4. Capa de Entidades:
* Define las entidades del dominio.
* Representa las estructuras de datos utilizadas en la aplicación.

5. Capa de DTOs (Data Transfer Objects):
* Utilizada para transferir datos entre las diferentes capas sin exponer las entidades directamente.
* Facilita la comunicación y transferencia de datos entre la API y el cliente.

![img.png](img.png)

