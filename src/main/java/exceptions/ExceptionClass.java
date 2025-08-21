package exceptions;

public class ExceptionClass {
    private int number;

    public ExceptionClass(int number) throws Exception {
        setNumber(number);
    }

    public void setNumber(int number) throws Exception {
        if (number < 0) {
            throw new Exception("I'm a Checked Exception. You always need to handle me with a try-catch");
        }
    }

    public static void throwUncheckedException() {
        throw new RuntimeException("I'm an Unchecked Exception and you don't need to handle me using a try-catch");
    }

    @Override
    public String toString() {
        return "ExceptionClass{" +
                "number=" + number +
                '}';
    }
}
