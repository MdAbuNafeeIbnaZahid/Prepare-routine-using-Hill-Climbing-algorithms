package Driver;

import HillClimbing.CandidateSolution;
import HillClimbing.HillClimb;
import IO.*;
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



        Configuration configuration = ConfigurationFactory.getProblem(in);

        out.println( configuration );

        HillClimb hillClimb = new HillClimb(configuration);

        CandidateSolution solution = hillClimb.climbHillRandomRestart();






        out.flush();
        out.close();
    }
}
