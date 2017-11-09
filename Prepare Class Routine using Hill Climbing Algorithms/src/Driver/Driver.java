package Driver;

import IO.*;
import IO.Input.ScannerFactory;
import IO.Output.PrintWriterFactory;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by nafee on 11/9/17.
 */




public class Driver {
    public static void main(String[] args) {

        Scanner in = ScannerFactory.getScanner("hdtt4req.txt");
//        Scanner in = ScannerFactory.getScanner(null);
        PrintWriter out = PrintWriterFactory.getPrintWriter("output.txt");

        System.out.println("in / out ready");


//        int i = in.nextInt();
//        System.out.println(i);

        while (in.hasNextLine())
        {
//            System.out.println("in has Next line");
            String s = in.nextLine();
//            System.out.println(s);
            out.println(s );
        }

        System.out.println("while loop is complete");

        out.flush();
        out.close();
    }
}
