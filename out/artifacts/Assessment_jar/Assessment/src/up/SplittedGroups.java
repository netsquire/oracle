package up;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static java.lang.System.out;

public class SplittedGroups {

    private static boolean splitInts(int[] nums) {
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        int g1=0;
        int g2=0;
        for (int value : nums){
            if (g1 >= g2) {
                g2 += value;
            } else {
                g1 += value;
            }
        }
        return g1 == g2;
    }

    public static void main(String[] a) {

        // Does it make sense to convert into Junit tests ?
        out.println(splitInts(new int[]{2, 2})); // → true
        assert(splitInts(new int[]{2, 2}));

        out.println(splitInts(new int[]{2, 3})); // → false
        assert( ! splitInts(new int[]{2, 3}));

        out.println(splitInts(new int[]{5, 2, 3})); // → true
        assert(splitInts(new int[]{5, 2, 3}));
    }
}
