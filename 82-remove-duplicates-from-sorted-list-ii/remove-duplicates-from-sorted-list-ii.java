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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode curAnsNode = newHead;
        ListNode curNode = head;
        while (curNode != null) {
            int curVal = curNode.val;
            if (curNode.next != null && curNode.val == curNode.next.val) {
                while (curNode != null && curNode.val == curVal) {
                    curNode = curNode.next;
                }
            }
            else{
                curAnsNode.next = curNode;
                curAnsNode = curNode;
                curNode = curNode.next;
            }
        }
        curAnsNode.next = null;
        return newHead.next;
    }
}