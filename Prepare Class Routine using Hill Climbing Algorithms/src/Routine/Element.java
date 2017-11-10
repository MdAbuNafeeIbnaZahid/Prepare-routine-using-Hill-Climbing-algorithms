package Routine;

import java.io.Serializable;

/**
 * Created by nafee on 11/9/17.
 */
public class Element implements Serializable {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;

        Element element = (Element) o;

        if (room != element.room) return false;
        if (cls != element.cls) return false;
        return teacher == element.teacher;
    }

    @Override
    public int hashCode() {
        int result = room;
        result = 31 * result + cls;
        result = 31 * result + teacher;
        return result;
    }
}
