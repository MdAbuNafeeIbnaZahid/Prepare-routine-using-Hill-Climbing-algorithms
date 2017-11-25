package Routine;

import java.util.Scanner;

/**
 * Created by nafee on 11/9/17.
 */
public class ConfigurationFactory {

    private static int[][][] take3dIntArInp(int x, int y, int z, Scanner scanner)
    {
        int[][][] ret = new int[x+9][y+9][z+9];
        for (int a = 1; a <=x; a++)
        {
            for (int b = 1; b <= y; b++)
            {
                for (int c = 1; c <= z; c++)
                {
                    int val;
                    val = scanner.nextInt();
                    ret[a][b][c] = val;
                }
            }
        }
        return ret;
    }

    public static Configuration getConfiguration(Scanner scanner)
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

        Configuration configuration= new Configuration(periodCnt, roomCnt, classCnt, teacherCnt, requirementAr);
        return configuration;
    }
}
