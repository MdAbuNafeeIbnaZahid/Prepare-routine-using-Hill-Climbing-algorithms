package Routine;

/**
 * Created by nafee on 11/9/17.
 */
public class Element {
    private int room;
    private int cls;
    private int teacher;

    public Element(int room, int cls, int teacher) {
        this.room = room;
        this.cls = cls;
        this.teacher = teacher;
    }

    public int getRoom() {
        return room;
    }

    public int getCls() {
        return cls;
    }

    public int getTeacher() {
        return teacher;
    }
}
