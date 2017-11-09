package Routine;

import java.util.Scanner;

/**
 * Created by nafee on 11/9/17.
 */
public class ProblemFactory {

    private static int[][][] take3dIntArInp(int x, int y, int z, Scanner scanner)
    {
        int[][][] ret = new int[x][y][z];
        for (int a = 0; a < ret.length; a++)
        {
            for (int b = 0; b < ret[a].length; b++)
            {
                for (int c = 0; c < ret[a][b].length; c++)
                {
                    int val;
                    val = scanner.nextInt();
                    ret[a][b][c] = val;
                }
            }
        }
        return ret;
    }

    public static Problem getProblem(Scanner scanner)
    {
        int periodCnt;
        int roomCnt;
        int classCnt;
        int teacherCnt;


        periodCnt = scanner.nextInt();
        roomCnt = scanner.nextInt();
        classCnt = scanner.nextInt();
        teacherCnt = scanner.nextInt();

        int[][][] requirementAr = take3dIntArInp(roomCnt, classCnt, teacherCnt, scanner);

        Problem problem = new Problem(periodCnt, roomCnt, classCnt, teacherCnt, requirementAr);
        return problem;
    }
}
