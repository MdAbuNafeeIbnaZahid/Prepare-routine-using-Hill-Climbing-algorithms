package Routine;

import HillClimbing.CandidateSolution;
import HillClimbing.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by nafee on 11/9/17.
 */
public class Configuration implements Problem {

   private int roomWeight = 1;
   private int classWeight = 2;
   private int teacherWeight = 3;

    public int getRoomWeight() {
        return roomWeight;
    }

    public int getClassWeight() {
        return classWeight;
    }

    public int getTeacherWeight() {
        return teacherWeight;
    }

    private int periodCnt;
    private int roomCnt;
    private int classCnt;
    private int teacherCnt;
    private int totalFrequencyCnt;
    private int[][][] frequencyAr;
    List<Element> elementList = new ArrayList<Element>();

    public void makeElementList()
    {
        for (int a = 1; a <= roomCnt; a++)
        {
            for (int b = 1; b <= classCnt; b++)
            {
                for (int c = 1; c <= teacherCnt; c++)
                {
                    int freq = getFrequency(a, b, c);
                    for (int d = 1; d <= freq; d++)
                    {
                        elementList.add( new Element(a, b, c) );
                    }
                }
            }
        }
    }

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
        makeElementList();
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
        return "Configuration{" +
                "periodCnt=" + periodCnt +
                ", roomCnt=" + roomCnt +
                ", classCnt=" + classCnt +
                ", teacherCnt=" + teacherCnt +
                ", totalFrequencyCnt=" + totalFrequencyCnt +
                ", frequencyAr=" + freqArToStr() +
                ", elementList=" + elementList +
                '}';
    }

    @Override
    public CandidateSolution getRandomCandidateSolution()
    {
        Timetable timetable = new Timetable(periodCnt, roomCnt, classCnt, teacherCnt, roomWeight, classWeight, teacherWeight);
        Random random = new Random();
        for (Element element : elementList)
        {
            int periodSlot = 1 + random.nextInt(periodCnt);
            timetable.addElement(periodSlot, element);
        }
        return timetable;
    }
}
