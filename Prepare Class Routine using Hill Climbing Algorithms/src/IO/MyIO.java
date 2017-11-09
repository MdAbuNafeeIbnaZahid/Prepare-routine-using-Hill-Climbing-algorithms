package IO;

import IO.Input.*;
import IO.Output.*;


import java.io.*;
import java.util.Scanner;

/**
 * Created by nafee on 11/9/17.
 */




public class MyIO  {

    private Scanner scanner = new Scanner(System.in);
    private PrintWriter printWriter = new PrintWriter(System.out);

    public MyIO(String inputFileName, String outputFileName)
    {
        scanner = ScannerFactory.getScanner(inputFileName);
        printWriter = PrintWriterFactory.getPrintWriter(outputFileName);
    }

    public int nextInt()
    {
        int i = scanner.nextInt();
        return i;
    }

    public void print(Object o)
    {
        printWriter.print(o);
    }

    public void println(Object o)
    {
        printWriter.println(o);
    }

    public void println()
    {
        printWriter.println();
    }

}
