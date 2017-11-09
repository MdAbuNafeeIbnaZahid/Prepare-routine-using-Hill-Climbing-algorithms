package Routine;

/**
 * Created by nafee on 11/9/17.
 */
public class Problem {
    private int roomCnt;
    private int classCnt;
    private int teacherCnt;
    private int periodCnt;
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

    public int getTotalRequirementCnt() {
        return totalRequirementCnt;
    }


    public Problem(int roomCnt, int classCnt, int teacherCnt, int periodCnt, int[][][] requirementAr) {
        this.roomCnt = roomCnt;
        this.classCnt = classCnt;
        this.teacherCnt = teacherCnt;
        this.periodCnt = periodCnt;
        this.requirementAr = requirementAr;
    }

    public int getRequirement(int room, int cls, int teacher)
    {
        return requirementAr[room][cls][teacher];
    }


}
