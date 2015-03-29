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
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i = l1;
        ListNode j = l2;
        ListNode answer = null;
        ListNode topAnswer = null;
        int sum = 0;
        int isCarry = 0;// next num will plus one
        while ((i != null || j != null) || isCarry==1) {
            sum=0;
            if(i!=null){
                sum +=  i.val;
            } 
            if(j!=null){
                sum +=  j.val;
            }
            if(i==null && j==null && isCarry==1){
               sum=0;
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

            if(answer==null){
                answer  = new  ListNode(sum);
                topAnswer = answer;
            }else{
                answer.next = new  ListNode(sum);
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        ListNode tmp = new ListNode(4);
//        l1.next = tmp;
//        tmp.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
//        tmp = new ListNode(6);
//        l2.next = tmp;
//        tmp.next = new ListNode(4);

        System.out.println(l1);
        System.out.println(l2);

        ListNode i = l1;
        ListNode j = l2;
        ListNode answer = null;
        ListNode topAnswer = null;
        int sum = 0;
        int isCarry = 0;// next num will plus one
        while ((i != null || j != null) || isCarry==1) {
            sum=0;
            if(i!=null){
                sum +=  i.val;
            } 
            if(j!=null){
                sum +=  j.val;
            }
            if(i==null && j==null && isCarry==1){
               sum=0;
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

            if(answer==null){
                answer  = new  ListNode(sum);
                topAnswer = answer;
            }else{
                answer.next = new  ListNode(sum);
                answer = answer.next;
            }

            if (i != null) {
                i = i.next;
            }
            if (j != null) {
                j = j.next;
            }
        }
        System.out.println(topAnswer);
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