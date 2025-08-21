import exceptions.ExceptionClass;

public class ExceptionsTest {

    public static void main(String[] args) {

        try {
            System.out.println(new ExceptionClass(-1));
            System.out.println("This line will be skipped if an exception is thrown");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("This line always will be executed");
        }

        ExceptionClass.throwUncheckedException();
    }
}
