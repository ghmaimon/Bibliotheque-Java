package exceptions;

public class CapacityExceededException extends Exception {

    public CapacityExceededException(int x,String topic){
        System.out.println("Capacity exceeded by " + x + " in " + topic);
    }
}