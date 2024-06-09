#SUMMARY
This work has been done by the student Iván García Pallares.

The work focuses an interpreter on a grammar, both made from 0.
The grammar is focused on a calculator with variables, returning as a result the value of each one inside>.

#CONTRIBUTION
Everything has been done by the only member

#INSTALL AND RUN

- INSTALLATION
Install antlr complete 4.13.1
Assign the generated file in the libraries folder
Get into the library and assign runs

Generate .g4 files
From the generated ones Compile all the .java files

Compile the Interpreter
Execute the interpreter with the file test.txt inside the same directory.


- EXECUTION
curl -O https://www.antlr.org/download/antlr-4.13.1-complete.jar
sudo mv antlr-4.13.1-complete.jar /usr/local/lib/

export CLASSPATH=“.:/usr/local/lib/antlr-4.13.1.1-complete.jar”
alias antlr4='java -Xmx500M -cp “/usr/local/lib/antlr-4.13.1.1-complete.jar:$CLASSPATH” org.antlr.v4.Tool'
alias grun='java -Xmx500M -cp “/usr/local/lib/antlr-4.13.1-complete.jar:$CLASSPATH” org.antlr.v4.gui.TestRig'

antlr4 -no-listener -visitor Calculator.g4
javac Calculator*.java

javac CalculatorRunner.java
java CalculatorRunner

#HOW TO USE AND EXAMPLE
To use it, inside the 'save' file are all the necessary files for configuration and execution.
Inside this directory also includes the script config.sh that already configures everything and executes it with the first >
For its first execution it is done by typing in the terminal -> source config.sh
Once executed once everything is configured and it is not necessary to run the script again.
It is only necessary to run the Interpreter 'CalculatorRunner.java' as follows -> java CalculatorRu>
In case you want to change the test run 'nano CalculatorRunner.java'.
And in the test.txt poser replace it with -> test.txt test2.txt test3.txt

- 1st use
cd file-path/save

//We will need to give special permissions to move the generated antlr4 file into the libraries folder
source config.sh

///Now we have it all configured and run once with the test 'test.txt' and it has positioned us in a folder>.
//If we want to run it again perform:
java CalculatorRunner

//In case of changing a test
nano CalculatorRunner.java
// Replace in line 10 the file test.txt by the desired one -> test.txt test2.txt test3.txt test3.txt

// Compile and run
javac CalculatorRunner.java
java CalculatorRunner

