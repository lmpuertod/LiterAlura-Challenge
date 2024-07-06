<h1 align="center"> LiterAlura Challenge </h1>

Aplicación de consola que sirve para consultar información sobre libros y sus autores usando la API [Gutendex](https://gutendex.com/)

## :hammer:Funcionalidades del proyecto
El menú de la aplicación tiene cinco opciones:
- `Opción 1`: En esta opción el usuario ingresa palabras clave sobre un libro (preferiblemente el titulo exacto del libro o una combinación de una palabra que aparezca en el titulo y el nombre de su autor ), la aplicación realiza una consulta a la API [Gutendex](https://gutendex.com/) y en caso de encontrar un libro con la información suministrada, muestra en la consola la información sobre el libro encontrado y su autor y la almacena persistentemente en la base de datos de la aplicación.  
- `Opción 2`: Con esta opción se muestra en la consola información de todos los libros que se han consultado previamente y que están almacenados en la base de datos de la aplicación.
- `Opción 3`: Esta opción muestra en la consola información de todos los autores de libros que se han consultado previamente y que están almacenados en la base de datos de la aplicación.
- `Opción 4`: En esta opción el usuario ingresa un año (en el calendario Gregoriano, enteros positivos para años d.C. y negativos para años a.C.) y la aplicación muestra en la consola información de todos los autores en la base de datos que estaban vivos en el año indicado.
- `Opción 5`: Muestra en la consola información sobre los libros en la base de datos escritos en el idioma especificado por el usuario (el nombre del idioma debe estar en español y con tildes)

## Uso
Para usar la aplicación hay que especificar la información de la base de datos que va a usar la aplicación, para hacer esto hay que definir las siguientes variables de entorno: 
- `DB_HOST` (Host de la base de datos; por ejemplo, para una base de datos local `localhost:puerto`, donde puerto es el puerto que utiliza la base de datos)
- `DB_NAME` (Nombre de la base datos)
- `DB_USER_NAME` (Nombre del usuario de la base de datos)
- `DB_PASSWORD` (Password del usuario)

Tambien se puede modificar la información anterior directamente en el archivo `src\main\resources\application`.

Por defecto la aplicación usa PostgreSQL,  si se quiere utilizar otro RDBMS se debe modificar tambien la información correspondiente en las variables `spring.datasource.url`, `spring.datasource.driver-class-name`,`hibernate.dialect` en el archivo `src\main\resources\application`.  
