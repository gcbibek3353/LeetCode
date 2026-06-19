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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode reversedList = reverse(slow);
        ListNode curHead1 = head;
        ListNode curHead2 = reversedList;
        int max = 0;
        while(curHead1 != null && curHead2 != null) {
            int curSum = curHead1.val + curHead2.val;
            curHead1 = curHead1.next;
            curHead2 = curHead2.next;
            max = Math.max(max , curSum);
        }
        return max;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}