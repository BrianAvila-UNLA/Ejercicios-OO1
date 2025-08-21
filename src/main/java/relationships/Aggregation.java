package relationships;

import java.util.List;

public class Aggregation {
    private List<String> strings;
    private int anotherAttribute;

    public Aggregation(List<String> strings, int anotherAttribute) {
        this.strings = strings;
        this.anotherAttribute = anotherAttribute;
    }
}
