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
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curNode = head;
        while(curNode != null){
            ListNode temp = new ListNode();
            temp = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = temp;
        }
        return prev;
    }
}