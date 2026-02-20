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
        ListNode lesserNodeHead = new ListNode();
        ListNode lessercurNode = lesserNodeHead;
        ListNode greaterNodeHead = new ListNode();
        ListNode greatercurNode = greaterNodeHead;
        ListNode curNode = head;
        while(curNode != null){
            if(curNode.val < x){
                lessercurNode.next = curNode;
                lessercurNode = curNode;
            }
            else{
               greatercurNode.next = curNode;
                greatercurNode = curNode;  
            }
            curNode = curNode.next;
        }
        greatercurNode.next = null;
        lessercurNode.next = greaterNodeHead.next;
        return lesserNodeHead.next;
    }
}