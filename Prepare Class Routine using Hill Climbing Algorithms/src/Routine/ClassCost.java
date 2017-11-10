package Routine;

/**
 * Created by nafee on 11/10/17.
 */
public class ClassCost extends ConflictCost {
    @Override
    int getVal(Element element) {
        return element.getCls();
    }
}


