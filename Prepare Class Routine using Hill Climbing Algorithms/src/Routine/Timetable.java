package Routine;

import Copy.UnoptimizedDeepCopy;
import HillClimbing.CandidateSolution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nafee on 11/9/17.
 */
public class Timetable implements CandidateSolution {

    private int periodCnt;
    private int roomCnt;
    private int classCnt;
    private int teacherCnt;

    private int roomWeight;
    private int classWeight;
    private int teacherWeight;


    private List<Period>  schedule;

    public Timetable(int periodCnt, int roomCnt, int classCnt, int teacherCnt, int roomWeight,
                     int classWeight, int teacherWeight)
    {

        this.periodCnt = periodCnt;
        this.roomCnt = roomCnt;
        this.classCnt = classCnt;
        this.teacherCnt = teacherCnt;

        this.roomWeight = roomWeight;
        this.classWeight = classWeight;
        this.teacherWeight = teacherWeight;

        schedule = new ArrayList<Period>(periodCnt+9);
        for (int a = 1; a <= periodCnt; a++ )
        {
            schedule.set(a, new Period());
        }
    }


    boolean addElement(int periodSlot, Element element)
    {
        boolean bool;
        assert ( ( 1 <= periodSlot ) && ( periodSlot <= periodCnt ) ) : "It fails ( 1 <= periodSlot ) && ( periodSlot <= periodCnt ) ";

        bool = schedule.get( periodSlot ).add(element);
        return bool;
    }

    boolean doesContains(int periodSlot, Element element)
    {
        boolean bool;
        bool = schedule.get(periodSlot).doesContain(element);
        return bool;
    }

    boolean removeElement(int periodSlot, Element element)
    {
        assert doesContains(periodSlot, element) : " Element not present in that period ";
        boolean bool = schedule.get(periodSlot).remove(element);
        return bool;
    }


    Timetable getNewTimeTable(int oldPeriodSlot, int newPeriodSlot, Element element)
    {
        assert doesContains(oldPeriodSlot, element) : "Element not present in that period";

        Timetable newTimeTable = (Timetable) UnoptimizedDeepCopy.copy(this);
        newTimeTable.removeElement(oldPeriodSlot, element);
        newTimeTable.addElement(newPeriodSlot, element);

        return newTimeTable;

    }


    @Override
    public int getCost() {
        int cost = 0;
        for ( Period period : schedule )
        {
            cost += period.getCost(roomWeight, classWeight, teacherWeight);
        }
        return cost;
    }

    @Override
    public List<CandidateSolution> getSuccessors() {
        List<CandidateSolution> successors = new ArrayList<CandidateSolution>();
        for (int a = 1; a <= periodCnt; a++) // old period slot
        {
            Iterator<Element> elementIterator = schedule.get(a).getElementsIterator();
            while (elementIterator.hasNext())
            {
                Element element = elementIterator.next();
                for (int b = 1; b <= periodCnt; b++) // new period slot
                {
                    if (a == b)
                    {
                        continue;
                    }
                    CandidateSolution newTimeTable = this.getNewTimeTable(a, b, element);
                    successors.add(newTimeTable);
                }
            }

        }
        return successors;
    }
}
