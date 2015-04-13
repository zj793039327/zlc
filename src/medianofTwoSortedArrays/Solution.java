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
     * 思路描述
     * <ol>
     * <li>
     * 认定第一个数组m长度大于第二个n</li>
     *  <li>
     * 寻找两个数组的中位数, 相当于在 m中寻找一个i, 将m分为
     * <br>
     * <code>{ A[0], A[1], ... , A[i - 1] } | { A[i], A[i + 1], ... , A[m - 1] }</code>
     * <br> 同样, 在n中可以寻找 一个j , 将n分为<br>
     * <code>{ B[0], B[1], ... , B[j - 1] } | { B[j], B[j + 1], ... , B[n - 1] }</code>
     * </li>
     * <li>
     * 在m中寻找一个i, n中寻找一个j 满足以下两个条件<br>
     * <code>
     *             左半边                |            右半边 <br>
            { A[0], A[1], ... , A[i - 1] } | { A[i], A[i + 1], ... , A[m - 1] } <br>
            { B[0], B[1], ... , B[j - 1] } | { B[j], B[j + 1], ... , B[n - 1] } <br>
     * 
     * </code>
     *  <ol>
     *      <li> 左边的元素总数 = 右边的总数(或者右边的总数+1, 总数为奇数出现此种情况)</li>
     *      <li> 左边的元素全部小于右边的元素  </li>
     *  </ol>
     * 
     * </li>
     * <li></li>
     * </ol>
     * @param A
     * @param B
     * @return
     * @author zhjing
     * @time 2015-4-13下午7:45:00
     */
    public double findMedianSortedArrays(int A[], int B[]) {
        return 1;
    }
}

