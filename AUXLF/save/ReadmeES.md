#RESUMEN
Este trabajo a sido realizado por el estudiante Iván García Pallares.

El trabajo enfoca un interprete sobre una gramámica, ambas realizadas desde 0.
La gramática esta enfocada a una calculadora con variables, devolvieldo como resultado el valor de cada una dentro de todas las operaciones presentadas.

#CONTRIBUCIÓN
Todo a sido realizado por el único miembro

#INSTALAR Y EJECUTAR

- INSTALACION
Instalar el antlr completo 4.13.1
Asignar el archivo generado en la carpeta de librerías
Meternos dentro de la librería y asignar ejecuciones

Generar archivos del .g4
De los generados Compilar todos los .java

Compilar el Interprete
Ejecutar el interprete con el archivo test.txt dentro del mismo directorio


- EJECUCIÓN
curl -O https://www.antlr.org/download/antlr-4.13.1-complete.jar
sudo mv antlr-4.13.1-complete.jar /usr/local/lib/

export CLASSPATH=".:/usr/local/lib/antlr-4.13.1-complete.jar"
alias antlr4='java -Xmx500M -cp "/usr/local/lib/antlr-4.13.1-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
alias grun='java -Xmx500M -cp "/usr/local/lib/antlr-4.13.1-complete.jar:$CLASSPATH" org.antlr.v4.gui.TestRig'

antlr4 -no-listener -visitor Calculator.g4
javac Calculator*.java

javac CalculatorRunner.java
java CalculatorRunner

#COMO USAR Y EJEMPLO
Para usarlo, dentro del archivo 'save' están todos los archivos necesarios para la configuración y ejecución.
Dentro de este directorio también incluye el script config.sh que ya lo configura todo y lo ejecuta con el primer test 'test.txt'.
Para su primera ejecución se realiza escribiendo en la terminal -> source config.sh
Una vez ejecutado una vez todo esta configurado y no es necesacio volver a ejecutar de nuevo el script.
Únicamente en necesario ejecutar el Interprete 'CalculatorRunner.java' de la siguiente manera -> java CalculatorRunner
En caso de querer cambiar el test ejecuar 'nano CalculatorRunner.java'
Y en el test.txt poser sustituirlo por -> test.txt test2.txt test3.txt

- 1r uso
cd path-del-archivo/save

//Necesitaremos darle permios especiales para poder mover el archivo antlr4 generado en la carpeta de librerias
source config.sh

//Ahora ya lo tenemos todo configurado y ejecutado una vez con el test 'test.txt' y nos a posicionado en una carpeta anterior donde estan todos los archivod
//Si queremos ejecutarlo otra vez realizar:
java CalculatorRunner

//En caso de cambiar un test
nano CalculatorRunner.java
// Sustituir en la linea 10 el archivo test.txt por el deseado -> test.txt test2.txt test3.txt

// Compilar y ejecutar
javac CalculatorRunner.java
java CalculatorRunner
