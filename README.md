
# Hibernate 

https://docs.jboss.org/hibernate/orm/6.2/userguide/html_single/Hibernate_User_Guide.html

## Introducción 

1. Java DataBase Connectivity (JDBC)

2. JPA (Java Persistence API) Especificación (javax.persistence o jakarta.persistence)
     Implementaciones:
     - Hibernate (ORM Object Relational Mapping)
     - EclipseLink

3. Spring Data JPA

CRUD - Create Retrieve Update Delete

## Bases de datos y herramientas

https://dev.mysql.com/downloads/installer/

https://mariadb.org/download

https://www.postgresql.org/download/

https://dbeaver.io/

## Configuración

1. Agregar dependencias maven en el fichero pom.xml: 

* hibernate-core
* Driver de base de datos: mysql, postgresql, etc, el que se quiera.

2. Crear fichero `hibernate.cfg.xml` en la carpeta src/main/resources y configurarlo

3. Crear objeto SessionFactory desde java: clase HibernateUtil

4. Crear modelos y realizar operaciones CRUD


## Operaciones de CRUD 

Create Retrieve Update Delete 

### Operaciones de lectura (Retrieve)

`SELECT * FROM table ... `

### Operaciones de escritura (Create, Update, Delete)

Create: `INSERT INTO table () values ();`

Update: `UPDATE table SET column1=value1, ...`

Delete: `DELETE FROM table ...`

## Se programa el código que interactúa con la base de datos en:

Clases Repository o DAO

Esquema general de una aplicación web con Hibernate:

Navegador-->Controlador-->Servicio-->DAO o Repository-->Base de datos (MySQL, PostgreSQL, H2, etc...)

## Poblar la base de datos

Hibernate ejecuta por defecto el archivo import.sql si es que existe. 

Con la propiedad `hibernate.hbm2ddl.import_files,otro_archivo` se puede indicar a Hibernate que ejecute 
más de un archivo SQL.

Se pueden insertar nuevos datos desde Java utilizando los métodos de la interfaz Session.

`Session session = HibernateUtil.getSessionFactory().openSession();`

## Asociaciones entre entidades 
* One To One
    * @OneToOne
    * @JoinColumn
    * @JoinTable
    * @PrimaryKeyJoinColumn
    * @MapsId

**Ejemplo:**

    ==================== ASOCIACIÓN: ONE TO ONE =========================
1. Asociación clave foránea: se crea una nueva columna en la tabla employees

    `@OneToOne` 
    
    `@JoinColumn(name = "direction_pk",`
    
    `foreignKey = @ForeignKey(name = "fk_employee_direction"))` // permite cambiar el nombre de la columna y de la fk

2. Asociación con tabla

    `@OneToOne`
    
    `@JoinTable(name = "ob_employee_direction",`
    
    `joinColumns = @JoinColumn(name="employee_id"),`
    
    `inverseJoinColumns = @JoinColumn(name="direction_id"))`

3. Asociación Clave primaria

    `@OneToOne`
    
    `@PrimaryKeyJoinColumn`

4. MapsId

    `@OneToOne`
    
    `@MapsId`
    
    `Location location;`



