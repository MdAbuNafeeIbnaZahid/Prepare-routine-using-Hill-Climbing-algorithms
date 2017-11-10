package Routine;

import HillClimbing.CandidateSolution;

import java.util.ArrayList;
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


    Timetable getNewTimeTable(int oldPeriodSlot, int newPeriodSlot, Element element)
    {
        assert doesContains(oldPeriodSlot, element) : "Element not present in that period";
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

    }
}
