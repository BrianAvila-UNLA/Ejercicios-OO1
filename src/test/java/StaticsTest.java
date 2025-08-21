import statics.UtilityClass;

public class StaticsTest {

    public static void main(String[] args) {
        System.out.println(UtilityClass.GLOBAL_CONSTANT);

        UtilityClass util = UtilityClass.create("Procrastinate");

        UtilityClass.printUtility(util);
    }
}
