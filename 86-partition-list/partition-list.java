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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode lesserHead = null;
        ListNode curLesserNode = null;
        ListNode greaterHead = null;
        ListNode curGreaterNode = null;
        ListNode curNode = head;
        while(curNode != null) {
            if(curNode.val < x) {
                if(curLesserNode == null) {
                    lesserHead = curNode;
                    curLesserNode = lesserHead;
                }
                else {
                    curLesserNode.next = curNode;
                    curLesserNode = curLesserNode.next;
                }
            }
            else {
                if(curGreaterNode == null) {
                    greaterHead = curNode;
                    curGreaterNode = greaterHead;
                }
                else {
                    curGreaterNode.next = curNode;
                    curGreaterNode = curGreaterNode.next;
                }
            }
            curNode = curNode.next;
        }
        if(curLesserNode != null) curLesserNode.next = greaterHead;
        else return greaterHead;
        if(curGreaterNode != null ) curGreaterNode.next = null;
        return lesserHead;
    }
}