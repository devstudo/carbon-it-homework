# Chasse au trésores project


The project use maven for project build, and tested with Junit 4

Java 1.8 is required

>1- to get the repository source code

````
  >`git clone https://github.com/devstudo/carbon-it-homework.git
````

OR download .zip 

>2- to run the aplication:

 
````
  > mvn exec:java
````

or get the jar file from your local repository at 
*.m2/repository/com/homework/chassetresore/chasse-tresore/1.0-SNAPSHOT/chasse-tresore-1.0-SNAPSHOT.jar*
after executing ```mvn clean install```:

``````
 > java -jar <PATH_TO_YOUR_JAR>
``````

and then enter the input file when asked on the console


>3- to run tests:

``````
 > mvn test
``````

>4- Result file:

the output file will be generated at the same INPUT PATH with the name:

```
"resultat-chasse-aux-tresores"
```


