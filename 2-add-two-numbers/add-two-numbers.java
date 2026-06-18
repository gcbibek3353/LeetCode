/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode curHead = null;
        while(l1 != null || l2 != null || carry > 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;
            int curSum = digit1 + digit2 + carry;
            carry = 0;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
            int curDigit = curSum;
            if(curSum >= 10){
                carry = curSum / 10;
                curDigit = curSum % 10;
            }
            System.out.printf("curDigit : %d", curDigit);
            ListNode newNode = new ListNode(curDigit);
            if(curHead == null) {
                head = newNode;
                curHead = head;
            }
            else {
                curHead.next = newNode;
                curHead = curHead.next;
            }
        }
        return head;
    }
}