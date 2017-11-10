package Routine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nafee on 11/10/17.
 */
public class Period {

    private List<Element> elements = new ArrayList<Element>();

    public Period() {
    }

    boolean add( Element element )
    {
        boolean bool = elements.add(element);
        return bool;
    }

    boolean doesContain(Element element)
    {
        boolean bool = elements.contains(element);
        return bool;
    }

    boolean remove(Element element)
    {
        boolean bool = elements.remove(element);
        return bool;
    }

    // I think this method is unnecessary
//    Iterator<Element> getIterator()
//    {
//        return elements.iterator();
//    }


    int getCost(int roomWeight, int classWeight, int teacherWeight)
    {
        int costInPeriod = 0;
        ConflictCost conflictCost;

        conflictCost = new RoomCost();
        int costInRoom = conflictCost.getSingleConflictCost(elements.iterator(), roomWeight);

        conflictCost = new ClassCost();
        int costInClass = conflictCost.getSingleConflictCost(elements.iterator(), classWeight);
        
        conflictCost = new TeacherCost();
        int costInTeacher = conflictCost.getSingleConflictCost(elements.iterator(), teacherWeight);

        costInPeriod = costInRoom + costInClass + costInTeacher;
        return costInPeriod;

    }
}
