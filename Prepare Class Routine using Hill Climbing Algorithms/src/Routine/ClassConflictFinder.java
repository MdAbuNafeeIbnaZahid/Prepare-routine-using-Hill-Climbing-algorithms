package Routine;

/**
 * Created by nafee on 11/10/17.
 */
public class ClassConflictFinder extends ConflictFinder {
    @Override
    public int getVal(Element element) {
        return element.getCls();
    }
}


