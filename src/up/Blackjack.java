package up;

import static java.lang.System.out;

public class Blackjack {

    private static final int PONTOON = 21;

    private static int pontoon(int a, int b) {
        // not defined the case if both values go over `PONTOON` - let it be negative 1
        if (transcend(a) && transcend(b)) {
            return -1;
        }
        if (transcend(a) && !transcend(b)) {
            return b;
        }
        if (transcend(b) && !transcend(a)) {
            return a;
        }
        if (undershot(a) < undershot(b)) {
            return a;
        }
        return b; // supposed undershot(b)<undershot(a)
    }

    private static int undershot(int d) {
        return PONTOON - d;
    }

    private static boolean transcend(int d) {
        return d> PONTOON;
    }

    public static void main(String[] a) {
        out.println("(19, 21) → (21) " + pontoon(19, 21)); // → 21
        assert (21 == pontoon(19, 21));

        out.println("(21, 19) → (21) " + pontoon(21, 19)); // → 21
        assert (21 == pontoon(21, 19));

        out.println("(19, 22) → (19) " + pontoon(19, 22)); // → 19
        assert (19 == pontoon(21, 19));

        out.println("(22, 19) → (19) " + pontoon(22, 19)); // → 19
        assert (19 == pontoon(21, 19));

        out.println("(22, 22) → (-1) " + pontoon(22, 22)); // → -1
        assert (-1 == pontoon(21, 19));
    }
}
