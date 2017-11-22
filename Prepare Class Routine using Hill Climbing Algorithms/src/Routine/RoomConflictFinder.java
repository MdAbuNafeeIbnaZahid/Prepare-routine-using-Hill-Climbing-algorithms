package Routine;

/**
 * Created by nafee on 11/10/17.
 */
public class RoomConflictFinder extends ConflictFinder {
    @Override
    int getVal(Element element) {
        return element.getRoom();
    }
}
