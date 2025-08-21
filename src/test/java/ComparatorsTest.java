import equalsAndToString.Person;

public class ComparatorsTest {

    public static void main(String[] args) {
        Person[] persons = new Person[3];
        persons[0] = new Person("Joel", 24);
        persons[1] = new Person("Joel", 24);
        persons[2] = new Person("Brian", 21);


        System.out.println("-- Use of toString() --\n");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }

        System.out.println("\n-- Use of equals() --\n");

        System.out.println("Is persons[0] equals to persons[1]? " + persons[0].equals(persons[1]));
        boolean isSameMemoryAddress = persons[0] == persons[1];
        System.out.println("Has persons[0] the same memory address than persons[1]? " + isSameMemoryAddress);
    }
}
