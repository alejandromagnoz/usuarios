# Api de creación de usuarios

Swagger http://localhost:8080/swagger-ui.html

Contiene los siguientes endpoints:

1-Endpoint de login para autenticación de forma segura con jwt
   https://localhost:8080/login
   
1.1.- Se debe ingresar el siguiente requestbody, tal como aparece en este ejemplo:
   
{
"username":"javainuse",
"password":"password"
}

1.2.- El resultado en response http status 200 en un token, por ejemplo:
{
"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhIiwiZXhwIjoxNjg0OTg0MzkzLCJpYXQiOjE2ODQ5NjYzOTN9.WlX8JROsISjehq3y_zMzFV3niHGXBJWXsCDcoXh6So2YDIT55b1EDGFDQ1SjcwzEYz0J_LsVTQvgH40M_vb7Eg"
}

1.3.- Ese token sirve para los endpoints siguiente para crear usuario
 
2-Endpoint para crear una venta
   https://localhost:8080/usuarios
   
2.1.- Se debe ingresar el token generado en el endpoit de login en el campo authorizationHeader, por ejemplo asì:
eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhIiwiZXhwIjoxNjg0OTkwMjM2LCJpYXQiOjE2ODQ5NzIyMzZ9.DS9SWpvDleXxBgvtFKxzIi4qLtoK1Q-61tcFrwWTJZQxrIiFIiHQGie7mnI8Kuv8jxaar0P53SC-kD4NsWcygQ

2.2.- Se debe ingresar un request body para crear el usuario (no olvidar ingresar el token, 
      como ejemplo de body userRequest es el siguiente:

{
"email": "tr@gmail.com",
"name": "tere",
"password": "09azAZ@#&",
"phones": [
{
"cityCode": "222",
"countryCode": "2222",
"number": "12345678"
}
]
}
2.3 Al ejecutar y todo va ok la respuesta es http status 200 y se retorna un json usuario reponse como el siguiente:

{
"active": true,
"id": "1",
"name": "tere",
"email": "tr@gmail.com",
"password": "09azAZ@#&",
"phones": [
{
"number": "12345678",
"cityCode": "222",
"countryCode": "2222"
}
],
"created": "2023-05-24 19:52:10",
"lastLogin": "2023-05-24 19:52:10",
"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhIiwiZXhwIjoxNjg0OTkwMjM2LCJpYXQiOjE2ODQ5NzIyMzZ9.DS9SWpvDleXxBgvtFKxzIi4qLtoK1Q-61tcFrwWTJZQxrIiFIiHQGie7mnI8Kuv8jxaar0P53SC-kD4NsWcygQ",
"isActive": true
}

2.4.- Si se ingresa un password en el body user request que no cumpla con la expresión regular definida en el archivo properties (esta expresión se puede modificar), tras ejecutar la api retorna el http status 400 Bad Request con el siguiente mensaje: El password no cumple con la expresion regular definida en el archivo properties
La expresión regular esta definida para permitir solo números de la siguiente forma:
^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$

2.5.- Si se ingresa un email en el body user request que no sea de tipo email, tras ejecutar la api retorna el http status 400 Bad Request

2.6.- Si se ingresa un email en el body user request que exista en la bd memoria H2, tras ejecutar la api retorna el http status CONFLICT  con el mensaje "El correo ya Existe"

2.7.- Ai iniciar la aplicación se crean en memoria las tablas user y phone en la bd H2 

create table phone (
phone_id bigint not null,
city_code varchar(255) not null,
country_code varchar(255) not null,
number varchar(255) not null,
user_id bigint not null,
primary key (phone_id)
)
create table user (
user_id bigint not null,
created varchar(255) not null,
email varchar(255) not null,
isactive boolean not null,
last_login varchar(255) not null,
name varchar(255) not null,
password varchar(255) not null,
token vartchar(255) not null,
primary key (user_id)
    )

## Estructura de directorios
```
/src/main/java/
/src/main/java/com/bank/configuration
/src/main/java/com/bank/controller
/src/main/java/com/bank/exception
/src/main/java/com/bank/model
/src/main/java/com/bank/repo
/src/main/java/com/bank/request
/src/main/java/com/bank/response
/src/main/java/com/bank/service
/src/main/java/com/bank/service/impl
/src/main/java/com/bank/util
/src/main/resources

```

## Instalación
1. Descargar e instalar maven.
2. Descargar el proyecto utilizando git:
```
git clone https://github.com/alejandromagnoz/usuarios.git


```
## Configuración
Abrir el proyecto de tipo **maven** en el IDE deseado y actualizar.  
Las versiones utilizadas están definidas en el archivo pom.xml.


## Ejecución
Para ejecutar el proyecto, se puede utilizar el IDE o simplemente desde la línea de
comandos, ejecutar cualquiera de estas opciones:

### Java

```
#java -jar target/usuario-backend 0.0.1-SNAPSHOT.jar
```

### Maven plugin
```
mvn spring-boot:run
```

## Pruebas
Para ejecutar las pruebas, es necesario ejecutar el comando siguiente:
```
mvn test
```

## Empaquetado
Para empaquetar el proyecto, es necesario ejecutar el siguiente comando:
```
mvn package
```
El jar es generado en el directorio target del proyecto.



## Misceláneo

### Repositorios del proyecto

| Tipo                             | Nombre    | URL                                               |
| -------------------------------- | --------- | -------------------------------------------------------------------- |
| Repositorio de código fuente     | GitHub    | https://github.com/alejandromagnoz/usuarios


### IDE sugerido
Spring Tool Suite version *IntelliJ IDEA 2023.1.2 (Community Edition)*


### Java
1.8
