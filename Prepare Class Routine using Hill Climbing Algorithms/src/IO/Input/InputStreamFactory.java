package IO.Input;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by nafee on 11/9/17.
 */
public class InputStreamFactory {

    public static InputStream getInputStream(String fileName)
    {
        if ( fileName == null )
        {
            return System.in;
        }

        InputStream is = null;
        try
        {
            is = new FileInputStream(fileName);
        }
        catch (Exception e)
        {
            System.out.println( fileName + "  can't be open " );
            System.out.println( e );
            System.exit(-1);
        }

        return is;
    }

}
