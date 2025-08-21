package relationships;

import java.util.ArrayList;
import java.util.List;

public class Composition {
    private List<String> strings;
    private int anotherAttribute;

    public Composition(int anotherAttribute) {
        this.anotherAttribute = anotherAttribute;
        strings = new ArrayList<>();
    }
}
