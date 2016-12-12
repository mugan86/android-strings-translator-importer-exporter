###(ENGLISH) Description about project.

The purpose is to create a table to translate texts in a simple way for more than one user without using Android Studio.

More info in WIKI: https://github.com/mugan86/android-strings-translator-importer-exporter/wiki/Introduction

Moment implement functions:

* Import original resource (strings.xml) to ObjectDB "translations" table.
* Export all complete translations to separate files after read data from ObjectDB data base "translations" table.

Future updates:

* Import original resource (strings.xml) to SQL format to add in our PHPMyAdmin database.
* Create an interface that gets the data from our SQL database to modify the data in a simple way before exporting it to the different files 'strings.xml'
* Export all complete translations to separate files after read data from SQL data base "translations" table.

###(Spanish) Descripción sobre el proyecto.

El objetivo principal de este proyecto es dar la posibilidad a los usuarios de poder traducir de una manera sencilla los textos de una app Android sin usar Android Studio.

Más información en el WIKI: https://github.com/mugan86/android-strings-translator-importer-exporter/wiki/Introduction

Funciones implementadas hasta el momento:

* Importar desde el fichero original (del idioma que partimos) a la Base de Datos en Object DB a la tabla "Translations" para editarlos dentro de dicha Base de datos usando 'explorer.jar' que se encuentra dentro del directorio **'readdb'**.
* Exportar las traducciones completadas (tienen que estar todos los campos rellenos) desde la tabla 'Translations' en la Base de Datos de tipo Object DB para crear diferentes ficheros en los idiomas creados.

Futuras funciones que se añadirán:

* Importar el fichero original (strings.xml) a SQL para usarlo en una Base de Datos de ese tipo.
* Crear una interfaz que obtiene los datos de nuestra base de datos SQL para modificar los datos de una manera sencilla antes de exportarlos a los diferentes ficheros 'strings.xml'.
* Exportar las traducciones completadas (tienen que estar todos los campos rellenos) desde la tabla 'Translations' de la Base de Datos de tipo SQL para crear diferentes ficheros en los idiomas creados.
