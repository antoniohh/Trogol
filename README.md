# Trogol

## Versión 2.1.0.0

## Proyecto Trogol. Curso de Perfeccionamiento Java. EII UEX.

### Novedades versión 2.1.0.0:

> Corregido el bug al comer el fantasma un trogol.

> Corregido el bug al restar la energía del trogol.

> En desarrollo el ejecutable para windows.

### Implementaciones.

> Base de datos SQLite con el conector SQLite JDBC Driver.

> Control de logs de ejecución mediante Apache Log4j.

> Fuente de iconos Font Awesome facilitados por jIconFont.

### Descripción.

La aplicación Trogol consiste en un juego escrito en Java. La finalidad del juego
se condigue conduciendo al trogol para comer las hamburguesas disponibles en el
panel, las cuales le aumentan la energía de forma aleatoria, evitando asi mismo
ser comido por los fantasmas.

El número de hamburguesas y fantasmas se puede seleccionar al hacer logging en el
juego, siendo su número predefinido 1,3,5,7,9.

Al iniciar una partida, se reproduce un sonido, se crea una instancia de un trogol,
tantas instancias de hamburguesas como se hayan seleccionado y tantos threads de
fantasmas se hayan seleccionado.

Cada vez que el trogol avanza una posición, aumenta en una unidad su puntuación y
disminuye en otra su energía. Para evitar perder energía debe ir comiendo hamburguesas,
incrementando pues su energía. Al comer una hamburguesa se reproduce un sonido.

Cuando su posición coincide con un fantasma, la energía disponible disminuye en
10 unidades.

Al perder el trogol toda su energía, finaliza la partida, deteniendo los threads
que controlan los fantasmas y reiniciando el panel para efectuar otra nueva partida.

Cuando la posición de un fantasma coincide con la del trogol o una hamburguesa se
reproduce un sonido y se crea una nueva instancia del trogol o de la hamburguesa
en otra posición aleatoria.

La aplicación Java se ha desarrollado en un proyecto de **Eclipse** con **Maven**.

### Dependencias.

Icono de la aplicación:

> [Desktop Halloween] (https://www.iconfinder.com/aha-soft)

Los iconos Font Awesome y librería java jIconFont:

> [Font Awesome] (https://fortawesome.github.io/Font-Awesome/)

> [jIconFont] (http://jiconfont.github.io/)

Control de Logs Apache Log4j:

> [Log4j] (https://logging.apache.org/)

SQLite Conector JDBC:

> SQLite JDBC Driver provided as a courtesy of [Taro L. Saito] (http://xerial.org/leo/)

> [JDBC] (https://bitbucket.org/xerial/sqlite-jdbc)

> [JDBC GitHub] (https://github.com/xerial/sqlite-jdbc)

Base de Datos SQLite:

> [SQLite] (https://sqlite.org/)

### Capturas.

Ventana de logging:

![Ventana de logging](https://dl.dropboxusercontent.com/u/3193442/Proyectos/Trogol01.png)

Elección del número de hamburguesas:

![Elección del número de hamburguesas](https://dl.dropboxusercontent.com/u/3193442/Proyectos/Trogol02.png)

Elección del número de fantasmas:

![Elección del número de fantasmas](https://dl.dropboxusercontent.com/u/3193442/Proyectos/Trogol03.png)

Ventana principal del juego:

![Ventana principal del juego](https://dl.dropboxusercontent.com/u/3193442/Proyectos/Trogol04.png)

Partida en proceso:

![Partida en proceso](https://dl.dropboxusercontent.com/u/3193442/Proyectos/Trogol05.png)

Ventana de información:

![Ventana de información](https://dl.dropboxusercontent.com/u/3193442/Proyectos/Trogol06.png)

### Licencia.

**GNU GENERAL PUBLIC LICENSE** Version 3, 29 June 2007. Ver el archivo LICENSE.

Trogol.
