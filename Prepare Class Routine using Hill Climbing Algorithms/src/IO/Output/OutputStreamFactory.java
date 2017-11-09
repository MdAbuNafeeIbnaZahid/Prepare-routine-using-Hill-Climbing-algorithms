package IO.Output;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by nafee on 11/9/17.
 */
public class OutputStreamFactory {
    public static OutputStream getOutputStream(String fileName)
    {
        if (fileName == null)
        {
            return System.out;
        }

        OutputStream os = null;
        try
        {
            os = new FileOutputStream(fileName);
        }
        catch (Exception e)
        {
            System.out.println(fileName + " can't be opened ");
            System.out.println( e );
            System.exit(-1);
        }

        return  os;
    }
}
