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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode curNode = head;
        while(list1 != null || list2 != null) {
            if(list1 == null){
                curNode.next = list2;
                curNode = curNode.next;
                list2 = list2.next;
                continue;
            }
            if(list2 == null){
                curNode.next = list1;
                curNode = curNode.next;
                list1 = list1.next;
                continue;
            }
            int list1Val = list1.val;
            int list2Val = list2.val;
            if(list1Val <= list2Val) {
                curNode.next = list1;
                list1 = list1.next;
                curNode = curNode.next;
            }
            else {
                curNode.next = list2;
                list2 = list2.next;
                curNode = curNode.next;
            }
        }
        return head.next;
    }
}