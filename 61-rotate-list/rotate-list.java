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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int count = 0;
        ListNode curNode = head;
        while(curNode != null){
            count ++;
            curNode = curNode.next;
        }
        k = k % count;
        int offset = count - k;
        ListNode newHead = null;
        int movedCount = 0;
        curNode = head;
        while(movedCount != offset - 1) {
            curNode = curNode.next;
            movedCount ++;
        }
        newHead = curNode.next;
        curNode.next = null;
        if(newHead == null) return head;
        movedCount = 0;
        curNode = newHead;
        while(movedCount != k - 1){
            curNode = curNode.next;
            movedCount ++;
        }
        curNode.next = head;
        return newHead;
    }
}