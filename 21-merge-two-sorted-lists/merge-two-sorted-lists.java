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
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        ListNode curNode1 = list1;
        ListNode curNode2 = list2;
        while(curNode1 != null && curNode2 != null) {
            if(curNode1.val < curNode2.val){
                cur.next = curNode1;
                cur = cur.next;
                curNode1 = curNode1.next;
            }
            else{
                cur.next = curNode2;
                cur = cur.next;
                curNode2 = curNode2.next;
            }
        }
        if(curNode1 != null) cur.next= curNode1;
        if(curNode2 != null) cur.next = curNode2;
        return dummyHead.next;
    }
}