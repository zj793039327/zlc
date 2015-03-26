package twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * Solution
 * @author zjhome
 * @time 2015-3-25下午10:22:00
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {

        /*
         * Normal solution which is O(n^2) run-time complexity
         * 
         * There is a nested loop just for searching In the second loop , we can
         * use a hashmap to reduce the searching time complexity from O(n) to
         * O(1) (the map's `key` is the number, the `value` is the position)
         * 
         * 
         * nt indexFirst=0; int indexEnd=0; for (int i : numbers) {
         * indexFirst++; for (int j : numbers) { indexEnd++; if (i + j ==
         * target) { System.out.println("" + i + j + target); return new int[] {
         * indexFirst, indexEnd }; } } indexEnd = 0; } return new int[] {
         * indexFirst, indexEnd };
         */

        Map<Integer, Integer> iterated = new HashMap<Integer, Integer>();

        for (int i=0;i<numbers.length;i++) {
            if (iterated.containsKey(numbers[i])) {
                return new int[] { iterated.get(numbers[i])+1,
                        i+1 };
            }
            iterated.put(target - numbers[i], i);
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,3,4};
//        for (int i = 0; i < 40000; i += 2) {
//            numbers[i / 2] = i;
//        }

        int target = 6;
        System.out.println(Arrays.toString(new Solution().twoSum(numbers,
            target)));
    }
}
