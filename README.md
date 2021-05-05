# compilation et execution:

## Pour Compiler:
    cd src
    export PATH_TO_FX=../lib
    javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml,mysql-connector */*.java App.java
## Pour executer:
    java --module-path $PATH_TO_FX --add-modules javafx.controls,mysql-connector App