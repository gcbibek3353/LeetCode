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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prevNode = null;
        ListNode curNode = slow;
        while(curNode != null) {
            ListNode temp = curNode;
            curNode = curNode.next;
            temp.next = prevNode;
            prevNode = temp;
        }
        ListNode firstHead = head;
        ListNode secondHead = prevNode;
        while(secondHead != null) {
            if(firstHead.val != secondHead.val) return false;
            secondHead = secondHead.next;
            firstHead = firstHead.next;
        }
        return true;
    }
}