package Routine;

import Copy.UnoptimizedDeepCopy;
import HillClimbing.CandidateSolution;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nafee on 11/9/17.
 */
public class Timetable implements CandidateSolution, Serializable {

    private int periodCnt;
    private int roomCnt;
    private int classCnt;
    private int teacherCnt;

    private int roomWeight;
    private int classWeight;
    private int teacherWeight;


    private List<Period>  schedule = new ArrayList<Period>();

    int getPeriodCost(int periodSlot)
    {
        assert ( ( 1 <= periodSlot ) && ( periodSlot <= periodCnt ) ) : "It fails ( 1 <= periodSlot ) && ( periodSlot <= periodCnt ) ";
        return schedule.get(periodSlot).getCost(roomWeight, classWeight, teacherWeight);
    }


    public Timetable getCopy(Timetable timetable) {
        return  (Timetable) UnoptimizedDeepCopy.copy(timetable);
    }


    public Timetable moveElement(int fromPeriodSlot, int toPeriodSlot, Element element)
    {
        this.removeElement(fromPeriodSlot, element);
        this.addElement(toPeriodSlot, element);
        return this;
    }

    // it returns ( newCost - oldCost )
    public int getCostChange(int fromPeriodSlot, int toPeriodSlot, Element element)
    {
        int prevCost = getPeriodCost(fromPeriodSlot) + getPeriodCost(toPeriodSlot);

        // change the time table
        this.moveElement(fromPeriodSlot, toPeriodSlot, element);
        int nextCost = getPeriodCost(fromPeriodSlot) + getPeriodCost(toPeriodSlot);

        int costChange = nextCost-prevCost;

        // back to old timetable
        this.moveElement(toPeriodSlot, fromPeriodSlot, element);

        return costChange;
    }


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

//        schedule = new ArrayList<Period>(periodCnt+9);

//        schedule = Arrays.asList( new Period[periodCnt+9] );
        for (int a = 1; a <= periodCnt+9; a++)
        {
            schedule.add(null);
        }
//        System.out.println( schedule.size() );

        for (int a = 1; a <= periodCnt; a++ )
        {
//            System.out.println(a);
            schedule.add(a, new Period() );
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
        assert ( ( 1 <= periodSlot ) && ( periodSlot <= periodCnt ) ) : "It fails ( 1 <= periodSlot ) && ( periodSlot <= periodCnt ) ";
        boolean bool;
        bool = schedule.get(periodSlot).doesContain(element);
        return bool;
    }

    boolean removeElement(int periodSlot, Element element)
    {
        assert ( ( 1 <= periodSlot ) && ( periodSlot <= periodCnt ) ) : "It fails ( 1 <= periodSlot ) && ( periodSlot <= periodCnt ) ";
        assert doesContains(periodSlot, element) : " Element not present in that period ";
        boolean bool = schedule.get(periodSlot).remove(element);
        return bool;
    }


    Timetable getNewTimeTable(int oldPeriodSlot, int newPeriodSlot, Element element)
    {
        assert doesContains(oldPeriodSlot, element) : "Element not present in that period";

        Timetable newTimeTable = (Timetable) UnoptimizedDeepCopy.copy(this);

//        System.out.println( this.doesContains(oldPeriodSlot, element) );
//        System.out.println( newTimeTable.doesContains(oldPeriodSlot, element) );



        newTimeTable.removeElement(oldPeriodSlot, element);
        newTimeTable.addElement(newPeriodSlot, element);

        return newTimeTable;

    }


    @Override
    public int getCost() {
        int cost = 0;
        for (int a = 1; a <= periodCnt; a++)
        {
            Period period = schedule.get(a);
            cost += period.getCost(roomWeight, classWeight, teacherWeight);
        }
        return cost;
    }

    // CAUTION : it may return an empty list
    @Override
    public List<CandidateSolution> getSuccessors() {
        List<CandidateSolution> successors = new ArrayList<CandidateSolution>();
        for (int a = 1; a <= periodCnt; a++) // old period slot
        {
            if ( getPeriodCost(a) == 0 )
            {
                continue;
            }

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



//                    if ( getCostChange(a, b, element) >= 0 )
//                    {
//                        // This move is not going to give me better successor
//                        continue;
//                    }


                    CandidateSolution newTimeTable = this.getNewTimeTable(a, b, element);
                    successors.add(newTimeTable);
                }
            }

        }
        return successors;
    }

    private String scheduleToSTr()
    {
        String ret = "\n";
        for (int a = 1; a <= periodCnt; a++)
        {
            ret += "period " + a + "\n";
            ret += schedule.get(a).toString() + "\n";
        }
        ret += "\n";
        return ret;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "periodCnt=" + periodCnt +
                ", roomCnt=" + roomCnt +
                ", classCnt=" + classCnt +
                ", teacherCnt=" + teacherCnt +
                ", roomWeight=" + roomWeight +
                ", classWeight=" + classWeight +
                ", teacherWeight=" + teacherWeight +
                ", schedule=" + scheduleToSTr() +
                '}';
    }
}
