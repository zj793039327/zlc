package medianofTwoSortedArrays;

/**
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * Solution
 * @author zhjing
 * @time 2015-4-13下午7:44:27
 */
public class Solution {
    /**
     * https://leetcode.com/discuss/15790/share-my-o-log-min-m-n-solution-with-explanation
     * http://www.cnblogs.com/driftsky/p/4427534.html
     * @param A
     * @param B
     * @return
     * @author zhjing
     * @time 2015-4-13下午7:45:00
     */
    public static double findMedianSortedArrays(int A[], int B[]) {

        int m = A.length;
        int n = B.length;
        // 这里必须保证A长度小于B
        // 理解: i和j, 将AB两个数组划分为长度相同的两个集合, 如果A数组非常长, 那么i在划分中可能出现
         // len(A的右部加上B的全部) < len(A的左部)
        // 的情况， 此时，j计算值为负。 
        if (m > n) {
            return findMedianSortedArrays(B, A);
        }
        int imin = 0;
        int imax = m;
        int num1 = 0, i = 0, j = 0, num2 = 0;

        while (imin <= imax) {
            i = (imin + imax) / 2;
            j = (m + n + 1) / 2 - i;
            // 边界值需要保证
            if (j > 0 && i < m && B[j - 1] > A[i]) {
                imin = i + 1;
            } else if (i > 0 && j < n && A[i - 1] > B[j]) {
                imax = i - 1;
            } else {
                if (i == 0) {
                    num1 = B[j - 1];
                } else if (j == 0) {
                    num1 = A[i - 1];
                } else {
                    num1 = Math.max(A[i - 1], B[j - 1]);
                }
                break;
            }
        }
        if ((m + n) % 2 == 1) {
            return num1;
        }
        if (i == m) {
            num2 = B[j];
        } else if (j == n) {
            num2 = A[i];
        } else {
            num2 = Math.min(A[i], B[j]);
        }
        return (num1 + num2) / 2.0;
    }
    
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {1,2,3,4,7,9}, new int[] {8,10 }));

    }
}
