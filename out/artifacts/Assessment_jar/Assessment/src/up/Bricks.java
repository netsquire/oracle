package up;

import static java.lang.System.*;

public class Bricks {

    private static final int LONG_LENGTH = 5;
    private static final int SHORT_LENGTH = 1;

    private static boolean makeRow(int small, int big, int goal) {
        int shortChain = small * SHORT_LENGTH; // it's not a big deal in case SHORT_LENGTH == 1, but everything could change ))
        if (goal > (big* LONG_LENGTH + shortChain)) {
            return false;
        }
        return shortChain >= (goal % LONG_LENGTH);
    }

    public static void main(String[] a){
        out.println("makeRow(3, 1, 8) → " + makeRow(3,1,8));
        out.println("makeRow(3, 1, 9) → " + makeRow(3,1,9));
        out.println("makeRow(3, 2, 10) → " + makeRow(3,2,10));
    }
}
