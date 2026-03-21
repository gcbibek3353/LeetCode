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
    public ListNode mergeKLists(ListNode[] lists) {
        //custom comparator
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(int i = 0; i < lists.length; i ++){
            if(lists[i] != null) pq.add(lists[i]);
        } 
        
        ListNode head = null;
        ListNode cur = head;

        while(!pq.isEmpty()){
            ListNode curMinNode = pq.poll(); // returns curMinNode in log(k) time
            if(head == null){
                head = new ListNode(curMinNode.val);
                cur = head;
            }else{
                cur.next = new ListNode(curMinNode.val);
                cur = cur.next;
            }

            if(curMinNode.next != null) pq.add(curMinNode.next);
        }
        return head;
    }
}