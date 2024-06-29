
![](https://raw.githubusercontent.com/facundoprocelli/CarreraDePatentes/main/repo-banner.png)

## Descripción del Proyecto

**CarreraDePatentes** es un proyecto personal diseñado para llevar un registro de un juego en el que amigos y familiares compiten para ver quién puede encontrar la patente de auto más nueva. La aplicación permite crear jugadores, actualizar las patentes que han encontrado y ver una tabla de posiciones que se puede ordenar por diferentes criterios. Además, incluye estadísticas básicas que proporcionan una visión general del juego.

El proyecto está desarrollado en Java utilizando Maven como herramienta de construcción y gestión de dependencias. La interfaz gráfica está construida con Java Swing y la base de datos se gestiona mediante MySQL en un servidor local XAMPP, utilizando phpMyAdmin para la administración.

## Características

- **Gestión de Jugadores**: Crear y actualizar jugadores.
- **Registro de Patentes**: Actualizar las patentes encontradas por cada jugador.
- **Tabla de Posiciones**: Ver la tabla de posiciones con filtros para ordenar por orden alfabético, días en el top 1 y patente más nueva.
- **Estadísticas**: Proveer estadísticas básicas del juego.

## Requisitos

- Java Development Kit (JDK) 8 o superior
- Apache Maven 3.6.0 o superior
- XAMPP (o cualquier servidor local compatible con MySQL)
- phpMyAdmin (opcional, para la administración de la base de datos)

## Instalación y Configuración

### 1. Configuración del Servidor Local

1. **Descargar e instalar XAMPP**
2. **Iniciar Apache y MySQL**: Abre el panel de control de XAMPP y enciende los servicios de Apache y MySQL.

### 2. Configuración de la Base de Datos

1. **Crear la Base de Datos**:
   - Accede a phpMyAdmin a través del navegador en `http://localhost/phpmyadmin`.
   - Crea una nueva base de datos llamada `carreradepatentes`.

2. **Crear las Tablas**:
   - Crea la tabla "usuarios" con: "id_usuario" , "nombre" , "patente" ,  "dias_primero".
   - Crea la tabla "fechas" con: "fecha".
     

### 3 Configuración del Proyecto

1. **Clonar el Repositorio**:
   - Clona este repositorio en tu máquina local.
   
     ```bash
     git clone <URL_DEL_REPOSITORIO>
     ```

2. **Compilar el Proyecto**:
   - Navega al directorio del proyecto y compílalo usando Maven.

     ```bash
     mvn clean package
     ```

### 4. Ejecución de la Aplicación

1. **Ejecutar el .exe**:
   - Descarga el archivo Carrera de Patentes.exe y ejecutalo.
  
     
1.1. **Iniciar la Aplicación**:
   - Ejecuta el archivo JAR generado.

     ```bash
     java -jar target/CarreraDePatentes.jar
     ```

2. **Cerrar Servidores**:
   - Para cerrar los servidores Apache y MySQL al cerrar la aplicación, se han incluido scripts de parada en el código Java.

## Uso de la Aplicación

### Funcionalidades Principales

- **Gestión de Jugadores**:
  - Puedes añadir nuevos jugadores y actualizar las patentes que han encontrado.
  
- **Tabla de Posiciones**:
  - Visualiza la tabla de posiciones y ordénala según:
    - Alfabéticamente
    - Días en el top 1
    - Patente más nueva
  
- **Estadísticas**:
  - Obtén estadísticas básicas del juego, como el jugador que más días ha estado en el top 1 y la patente más reciente.

### Ejemplos de Uso

#### Añadir un Jugador
1. Haz clic en "Añadir Jugador".

#### Actualizar Patente
1. Ingrese el nombre del jugador
2. Ingresa la nueva patente y guarda los cambios.

## Licencia

Este proyecto está bajo la Licencia MIT. Para más detalles, consulta el archivo LICENSE.

## Contacto

Para cualquier consulta o sugerencia, puedes contactarme a través de [mi email](mailto:tuemail@example.com).

---

¡Gracias por utilizar CarreraDePatentes!
