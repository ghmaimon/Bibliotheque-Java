<h1>LIBRARY PROJECT</h1>
<i><b>a library simulation desktop application</b></i><br>

<p>
in this application we can add users(students or professors) and documents(comics, dicionaries, books, and magazines),
and save user's borows, there is also other features like searching and deleting ...
</p><br>

<i>note: the project is in french</i><br>

## Compilation And Execution:
### To Compile:
    cd src
    export PATH_TO_FX=../lib
    javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml */*.java App.java
### To Excecute:
    java --module-path $PATH_TO_FX --add-modules javafx.controls -cp .:$PATH_TO_FX/mysql-connector-java-8.0.24.jar App

