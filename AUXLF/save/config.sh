#!/bin/bash

#
#EJECUTAR CON -> source config.sh
#Para garantizar que el export se realiza en nuestra shell
#

path1="/usr/local/lib"
path2=$(pwd)

#Asignamos las librería que necesitamos
curl -O https://www.antlr.org/download/antlr-4.13.1-complete.jar
echo ""
echo "Needs permission SUDO to add <antlr-4.13.1-complete.jar> in the directory $path1/"
sudo mv antlr-4.13.1-complete.jar $path1/


#Nos metemos en el Path del java con la librería que necesitamos
export CLASSPATH=".:/usr/local/lib/antlr-4.13.1-complete.jar"

#Asignamos a las funciones a las que vamos a llamar la librería de nuestro Path
alias antlr4='java -Xmx500M -cp "/usr/local/lib/antlr-4.13.1-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
alias grun='java -Xmx500M -cp "/usr/local/lib/antlr-4.13.1-complete.jar:$CLASSPATH" org.antlr.v4.gui.TestRig'


#Retrocedemos una carpeta para ejecutar ficheros mantienendo los de este archivo 'save' como un backup
cd ..

cp save/Calculator.g4 .
antlr4 -no-listener -visitor Calculator.g4
javac Calculator*.java

#Ejecutar tests
cp save/test.txt .
cp save/test2.txt .
cp save/test3.txt .

cp save/CalculatorRunner.java .
javac CalculatorRunner.java
java CalculatorRunner

#antlr4 -no-listener -visitor 'file'.g4
#javac 'file'*.java
#grun 'file' game -tree
#grun 'file' game -gui














