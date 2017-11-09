package Routine;

import java.util.Arrays;

/**
 * Created by nafee on 11/9/17.
 */
public class Problem {
    private int periodCnt;
    private int roomCnt;
    private int classCnt;
    private int teacherCnt;
    private int totalRequirementCnt;
    private int[][][] requirementAr;



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

    public void calculateTotalRequirementCnt()
    {
        int sum = 0;
        for (int[][] i : requirementAr)
        {
            for (int[] j : i)
            {
                for (int k : j)
                {
                    sum += k;
                }
            }
        }
        totalRequirementCnt = sum;
    }

    public int getTotalRequirementCnt() {
        return totalRequirementCnt;
    }


    public Problem(int periodCnt, int roomCnt, int classCnt, int teacherCnt,  int[][][] requirementAr) {
        this.roomCnt = roomCnt;
        this.classCnt = classCnt;
        this.teacherCnt = teacherCnt;
        this.periodCnt = periodCnt;
        this.requirementAr = requirementAr;
        calculateTotalRequirementCnt();
    }

    public int getRequirement(int room, int cls, int teacher)
    {
        return requirementAr[room][cls][teacher];
    }


    @Override
    public String toString() {
        return "Problem{" +
                "periodCnt=" + periodCnt +
                ", roomCnt=" + roomCnt +
                ", classCnt=" + classCnt +
                ", teacherCnt=" + teacherCnt +
                ", totalRequirementCnt=" + totalRequirementCnt +
                ", requirementAr=" + Arrays.deepToString(requirementAr) +
                '}';
    }
}
