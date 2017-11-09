package Routine;

import java.util.Arrays;

/**
 * Created by nafee on 11/9/17.
 */
public class Configuration {
    private int periodCnt;
    private int roomCnt;
    private int classCnt;
    private int teacherCnt;
    private int totalFrequencyCnt;
    private int[][][] frequencyAr;



    public int getRoomCnt() {
        return roomCnt;
    }

    public int getClassCnt() {
        return classCnt;
    }

    public int getTeacherCnt() {
        return teacherCnt;
    }

    public int getPeriodCnt() {
        return periodCnt;
    }

    public void calculateTotalFrequencyCnt()
    {
        totalFrequencyCnt = 0;
        for (int a = 1; a <= roomCnt; a++)
        {
            for (int b = 1; b <= classCnt; b++)
            {
                for (int c = 1; c <= teacherCnt; c++)
                {
                    totalFrequencyCnt += getFrequency(a, b, c);
                }
            }
        }
    }

    public int getTotalFrequencyCnt() {
        return totalFrequencyCnt;
    }


    public Configuration(int periodCnt, int roomCnt, int classCnt, int teacherCnt,  int[][][] requirementAr) {
        this.roomCnt = roomCnt;
        this.classCnt = classCnt;
        this.teacherCnt = teacherCnt;
        this.periodCnt = periodCnt;
        this.frequencyAr = requirementAr;
        calculateTotalFrequencyCnt();
    }

    public int getFrequency(int room, int cls, int teacher)
    {
        return frequencyAr[room][cls][teacher];
    }

    String freqArToStr()
    {
        String str = "\n";
        for (int a = 1; a <= roomCnt; a++)
        {
            for (int b = 1; b <= classCnt; b++)
            {
                for (int c = 1; c <= teacherCnt; c++)
                {
                    str += " " + Integer.toString( getFrequency(a,b,c) );
                }
                str += "\n";
            }
        }
        return str;
    }


    @Override
    public String toString() {
        return "Problem{" +
                "periodCnt=" + periodCnt +
                ", roomCnt=" + roomCnt +
                ", classCnt=" + classCnt +
                ", teacherCnt=" + teacherCnt +
                ", totalFrequencyCnt=" + totalFrequencyCnt +
                ", frequencyAr=" + freqArToStr() +
                '}';
    }
}
