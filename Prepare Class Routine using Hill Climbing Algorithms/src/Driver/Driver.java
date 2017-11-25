package Driver;

import HillClimbing.HillClimbingFactory;
import HillClimbing.CandidateSolution;
import HillClimbing.HillClimbing;
import IO.Input.ScannerFactory;
import IO.Output.PrintWriterFactory;
import Routine.Configuration;
import Routine.ConfigurationFactory;
import Routine.*;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by nafee on 11/9/17.
 */




public class Driver {
    public static void main(String[] args) {

        Scanner in = ScannerFactory.getScanner("hdtt4req.txt");
        PrintWriter out = PrintWriterFactory.getPrintWriter("output.txt");

//        System.out.println("in / out ready");



        Configuration configuration = ConfigurationFactory.getConfiguration(in);

        out.println( configuration );

        HillClimbing hillClimbing = HillClimbingFactory.getHillClimbing(configuration, HillClimbingFactory.STOCHASTIC_HILL_CLIMBING);

        CandidateSolution solution = hillClimbing.climbHillRandomRestart();

        Timetable timetable = (Timetable)solution;

        out.println("timeTable = " + timetable);





        out.flush();
        out.close();
    }
}
