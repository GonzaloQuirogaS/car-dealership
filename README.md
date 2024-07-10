# Documentación de Proyecto Concesionaria de Autos

## Descripción
Este proyecto **tiene como objetivo mostrar cómo se evaluan las habilidades de un desarrollador la creacion de APIs RESTful y en el manejo de bases de datos** A continuación, se proporciona una descripción general de las principales componentes y funcionalidades del proyecto.


## Características
El proyecto consiste en el desarrollo de una API **con tecnología Java utilizando el framework Spring Boot**. Este proyecto tiene como objetivo crear rutas e implementar acciones que permitan gestionar distintas operaciones y consultas a bases de datos. A continuación, se detallan las principales características de este proyecto:

1. **API**: La aplicación desarrollada se encarga de consumir la API  obteniendo información relevante sobre distintos autos. Se crea una API que ofrece diversas funcionalidades para obtener información de los autos registrado en la base de datos, incluyendo:
    - Búsqueda de autos por id.
    - Obtención del listado de autos.
    - Acceso a los datos de un auto por id.
    - Listado completo de ordenes realizadas.
    - Creacion de ordenes nuevas.
    - Guardado de autos en base de datos.
    - Gestion de carrito.
    - Visualizacion de estado de carrito.
    - Eliminar y modificar autos por id.
    - Acceso a los detalles de ordenes por id.

2. **Almacenamiento en Base de Datos**: Se implementa un esquema de base de datos, preferiblemente MySQL, para almacenar toda la información necesaria.


## Configuración
Antes de ejecutar la aplicación, es necesario configurar las siguientes propiedades en el archivo `application.properties`:

Se debe de configurar en el archivo application.properties las propiedades correspondientes para MySQL:
```properties
spring.datasource.url=jdbc:mysql://<Tu host>:<Tu puerto>/<Tu base de datos>
spring.datasource.username=<Tu username>
spring.datasource.password=<Tu password>
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
```

Ademas se configurar las propiedades de Swagger para visualizar las operaciones en la ruta '**/swagger-ui.html**'
```properties
springdoc.swagger-ui.enabled=true
springdoc.api-docs.enabled=true
springdoc.swagger-ui.path=/swagger-ui.html
```


## Paquetes del Proyecto
El proyecto está organizado en los siguientes paquetes:

- `com/app/cardealership/dto`: Contiene clases DTO.
- `com/app/cardealership/mapper`: Contiene mapeadores para convertir entre entidades y DTO.
- `com/app/cardealership/persistance/entities`: Define entidades de la base de datos.
- `com/app/cardealership/persistance/repository`: Define repositorios para acceder a la base de datos.
- `com/app/cardealership/services`: Define interfaces de servicio.
- `com/app/cardealership/services/impl`: Implementaciones de servicios.
- `com/app/cardealership/controllers`: Controladores web para manejar las solicitudes de la API.
- `com/app/cardealership/config`: Clases de configuracion.

## Clases Principales
A continuación, se describen algunas de las clases principales del proyecto:

### `CarRepository` , `OrderDetailRepository ` y ` OrderRepository`
- Repositorio que interactúa con la base de datos para obtener información sobre los autos, las ordenes y los detalles de ordenes. Proporciona métodos para operar sobre los elementos en la base de datos.


### `IOrderService` , `IOrderDetailService` y `ICarService`
- Interfaces de servicio que definen operaciones relacionadas con autos, ordenes y detalles de orden. Sus implementaciones se encuentran en `OrderServiceImpl` , `OrderDetailServiceImpl`y`CarServiceImpl` respectivamente.

### Controladores
- Los controladores, como `OrderDetailController`, `OrderController`, y `CarController`, gestionan las solicitudes HTTP y responden con datos a los clientes.


## Manejo de Excepciones
El proyecto incluye un sistema de manejo de excepciones que garantiza una respuesta adecuada a diferentes tipos de errores, como errores de autenticación y errores en las solicitudes. El manejo de excepciones se realiza a través de la libreria Validator.

## Scripts SQL
El proyecto incluye la configuración necesaria para que las tablas se creen automaticamente al ejecutar el proyecto.
Por defecto esta configuración se encuentra comentada pero basta con descomentar las siguientes propiedades para que se creen las tablas:

```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
```

## Swagger
Si se desea, se puede utilizar Swagger para visualizar las operaciones disponibles dentro de la app y operar sobre ellas. [Click aquí para ir a interfaz de Swagger](http://localhost:8080/swagger-ui/index.html)

## Resumen
Este documento proporciona una visión general de la estructura del proyecto y sus componentes clave. Asegúrate de configurar correctamente la clase application.properties antes de ejecutar la aplicación para que funcione correctamente.