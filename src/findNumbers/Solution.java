package findNumbers;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * 
 * Solution
 * @author zjhome
 * @time 2015-4-2上午8:33:28
 */
public class Solution {

    private int n = 100000000;

    private BitSet bs = new BitSet(n);

    public int[] findNums(int[] targetNums) {
        for (int i = 0; i < targetNums.length; i++) {
            bs.set(targetNums[i]);
        }

        int[] data = new int[n - bs.cardinality()];
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (!bs.get(i)) {
                data[counter++] = i;

            }
        }
        return data;

    }
}
