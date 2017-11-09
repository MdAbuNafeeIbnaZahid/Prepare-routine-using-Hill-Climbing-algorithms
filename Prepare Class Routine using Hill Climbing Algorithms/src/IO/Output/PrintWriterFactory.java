package IO.Output;

import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by nafee on 11/9/17.
 */
public class PrintWriterFactory {

    public static PrintWriter getPrintWriter(String fileName)
    {
        PrintWriter printWriter = new PrintWriter(System.out);

        if (fileName == null)
        {
            return printWriter;
        }

        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            printWriter = new PrintWriter(fileOutputStream);
        }
        catch (Exception e)
        {
            System.out.println("can't open file " + fileName);
            System.out.println(e);
            System.exit(-1);
        }

        return printWriter;

    }
}
