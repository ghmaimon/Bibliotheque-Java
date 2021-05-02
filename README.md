# compilation et execution:

## Pour Compiler:
    cd src
    export PATH_TO_FX=../../Dependecies/openjfx-16_linux-x64_bin-sdk/javafx-sdk-16/lib
    javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml */*.java App.java
## Pour executer:
    java --module-path $PATH_TO_FX --add-modules javafx.controls App