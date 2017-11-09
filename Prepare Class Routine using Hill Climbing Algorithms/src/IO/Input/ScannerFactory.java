package IO.Input;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Created by nafee on 11/9/17.
 */
public class ScannerFactory {
    public static Scanner getScanner(String fileName)
    {
        Scanner scanner = new Scanner(System.in);

        if (fileName == null)
        {
            return scanner;
        }

        try
        {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            scanner = new Scanner(fileInputStream);
        }
        catch (Exception e)
        {
            System.out.println("can't open the file " + fileName);
            System.out.println(e);
            System.exit(-1);
        }

        return scanner;

    }
}
