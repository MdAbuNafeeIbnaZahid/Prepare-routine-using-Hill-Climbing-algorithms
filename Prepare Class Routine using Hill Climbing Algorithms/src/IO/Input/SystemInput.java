package IO.Input;

import java.util.Scanner;

/**
 * Created by nafee on 11/9/17.
 */
public class SystemInput implements InputBehavior {

    private Scanner scanner;

    public SystemInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int readInt() {
        int ret = scanner.nextInt();
        return ret;
    }
}
