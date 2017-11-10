package Routine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nafee on 11/9/17.
 */
public class Timetable {

    private int periodCnt;
    private int roomCnt;
    private int classCnt;
    private int teacherCnt;

    private List<Period>  schedule;

    public Timetable(int periodCnt, int roomCnt, int classCnt, int teacherCnt) {
        this.periodCnt = periodCnt;
        this.roomCnt = roomCnt;
        this.classCnt = classCnt;
        this.teacherCnt = teacherCnt;
        schedule = new ArrayList<Period>(periodCnt+9);
        for (int a = 1; a <= periodCnt; a++ )
        {
            schedule.set(a, new Period());
        }
    }





}
