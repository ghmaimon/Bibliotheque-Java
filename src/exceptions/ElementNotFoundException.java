package exceptions;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String topic){
        System.out.println(topic + " not found");
    }
}
