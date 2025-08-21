package statics;

public class UtilityClass {
    private String utility;
    public static final String GLOBAL_CONSTANT = "I can be accessed without an instance";

    private UtilityClass(String utility) {
        this.utility = utility;
    }

    public static UtilityClass create(String utility) {
        return new UtilityClass(utility);
    }

    public static void printUtility(UtilityClass utilityClass) {
        System.out.println("My utility is: " + utilityClass.utility);
    }
}
