package addTwoNumbers;

/**
 * Solution
 * @author zhjing
 * @time 2015-3-26下午12:22:10<br>
 * <br>
 * 
 * You are given two linked lists representing two non-negative numbers. <br>
 * The digits are stored in reverse order and each of their nodes contain a single digit. <br>
 * Add the two numbers and return it as a linked list.<br>
 * <br>
 * <strong>Input</strong>: (2 -> 4 -> 3) + (5 -> 6 -> 4)<br>
 * <strong>Output</strong>: 7 -> 0 -> 8<br>
 *
 *
 * 给定两个单链表，代表两个非负数集合<br>
 * 每个节点中保存了一个一位数字, 将这两个数组结果相加, 产生一个新的链表
 * 
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i = l1;
        ListNode j = l2;
        ListNode answer = null;
        ListNode topAnswer = null;
        int sum = 0;
        int isCarry = 0;// next num will plus one // 进位
        while ((i != null || j != null) || isCarry == 1) {
            sum = 0;
            if (i != null) {
                sum += i.val;
            }
            if (j != null) {
                sum += j.val;
            }
            if (i == null && j == null && isCarry == 1) {
                sum = 0;
            }

            if (isCarry == 1) {
                sum++;
            }

            if (sum >= 10) {
                sum -= 10;
                isCarry = 1;
            } else {
                isCarry = 0;
            }

            if (answer == null) {
                answer = new ListNode(sum);
                topAnswer = answer;
            } else {
                answer.next = new ListNode(sum);
                answer = answer.next;
            }

            if (i != null) {
                i = i.next;
            }
            if (j != null) {
                j = j.next;
            }
        }
        return topAnswer;
    }

    /**
     * 实现的比较简洁的例子, 可以比较一下区别, 看下学到了什么
     * @param l1
     * @param l2
     * @return
     * @author Hao Chen
     * @time 2015-4-6下午10:49:36
     * @url https://github.com/haoel/leetcode/blob/master/algorithms/addTwoNumbers/addTwoNumbers.cpp
     */
    public ListNode addTwoNumbers_chen(ListNode l1, ListNode l2) {
        int x = 0, y = 0, carry = 0, sum = 0; //默认初始化为0
        ListNode tmp = null, answer = null;// 定义变量清楚明了

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            } else {
                x = 0;
            }
            
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            } else {
                y = 0;
            }

            sum = x + y + carry;

            ListNode node = new ListNode(sum % 10);
            if (tmp == null) {
                tmp = node;
                answer = node;
            } else {
                tmp.next = node;
                tmp = node;
            }

            carry = sum / 10;
        }//
        if (carry > 0) {
            ListNode node = new ListNode(carry % 10);
            tmp.next = node;
            tmp = node;
        }
        return answer;

    }

    private static int getValueAndMoveToNext(ListNode node) {
        int x = 0;
        if (node != null) {
            x = node.val;
            node = node.next;
        }
        return x;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode tmp = new ListNode(8);
        l1.next = tmp;
        //tmp.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
//        tmp = new ListNode(6);
//        l2.next = tmp;
//        tmp.next = new ListNode(4);

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(new Solution().addTwoNumbers_chen(l1, l2));

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        ListNode n = this;
        String rtn = "";
        while (n != null) {
            rtn += n.val + " -> ";
            n = n.next;
        }
        if (rtn.length() > 3) {
            rtn = rtn.substring(0, rtn.length() - 3);
        }
        return rtn;
    }
}