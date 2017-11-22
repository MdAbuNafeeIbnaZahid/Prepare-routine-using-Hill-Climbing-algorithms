package Routine;

/**
 * Created by nafee on 11/10/17.
 */
public class TeacherConflictFinder extends ConflictFinder {
    @Override
    int getVal(Element element) {
        return element.getTeacher();
    }
}
