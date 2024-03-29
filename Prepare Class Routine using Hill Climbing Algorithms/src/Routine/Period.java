package Routine;

import Copy.UnoptimizedDeepCopy;

import java.io.Serializable;
import java.util.*;

/**
 * Created by nafee on 11/10/17.
 */
public class Period implements Serializable {

    private List<Element> elements = new ArrayList<Element>();


    public Period() {
    }

    public Period getCopy()
    {
        return (Period) UnoptimizedDeepCopy.copy(this);
    }

//    static int getCostChange(Period from, Period to, Element element)
//    {
//        from = from.getCopy();
//        to = to.getCopy();
//
//        assert from.doesContain(element) : " Element is not present in from Period ";
//
//        int prevCost = from.getCost()
//    }

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
        ConflictFinder conflictFinder;

        conflictFinder = new RoomConflictFinder();
        int costInRoom = conflictFinder.getSingleConflictCost(elements.iterator(), roomWeight);

        conflictFinder = new ClassConflictFinder();
        int costInClass = conflictFinder.getSingleConflictCost(elements.iterator(), classWeight);

        conflictFinder = new TeacherConflictFinder();
        int costInTeacher = conflictFinder.getSingleConflictCost(elements.iterator(), teacherWeight);

        costInPeriod = costInRoom + costInClass + costInTeacher;
        return costInPeriod;

    }

    public Iterator<Element> getElementsIterator()
    {
        return elements.iterator();
    }

    public Iterator<Element> getConflictingElementIterator()
    {
        Set<Element> conflictingElements = new HashSet<Element>();


        ConflictFinder roomConflictFinder = new RoomConflictFinder();
        Iterator<Element> roomConflictingElementIterator = roomConflictFinder.getSingleConflictingElementsIterator(elements);


        ConflictFinder classConflictFinder = new ClassConflictFinder();
        Iterator<Element> classConflictingElementIterator = classConflictFinder.getSingleConflictingElementsIterator(elements);

        ConflictFinder teacherConflictFinder = new TeacherConflictFinder();
        Iterator<Element> teacherConflictingElementIterator = teacherConflictFinder.getSingleConflictingElementsIterator(elements);



        // forEachRemaining is an interesting feature of java 8
        roomConflictingElementIterator.forEachRemaining(conflictingElements::add);
        classConflictingElementIterator.forEachRemaining(conflictingElements::add);
        teacherConflictingElementIterator.forEachRemaining(conflictingElements::add);

        return conflictingElements.iterator();
    }

    @Override
    public String toString() {
        return "Period{" +
                "elements=" + elements +
                '}';
    }
}
