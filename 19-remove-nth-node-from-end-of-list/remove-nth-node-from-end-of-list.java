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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      if(n < 0) return head;
      int count = 0;
      ListNode curNode = head;
      while(curNode != null){
        count ++;
        curNode = curNode.next;
      }
      if(n > count) return head;
      if(n == count) return head.next;
      curNode = head;
      int num = count - n - 1;
      while(num > 0){
        num --;
        curNode = curNode.next;
      }
      curNode.next = curNode.next.next;
      return head;
    }
}