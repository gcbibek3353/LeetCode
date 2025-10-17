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
       if (head == null || head.next == null) return head;
    int length = 1;
    ListNode cur = head;
    while (cur.next != null) {
        cur = cur.next;
        length++;
    }
    cur.next = head;
    int cutPosition = length - (k % length);

    cur = head;
    for (int i = 1; i < cutPosition; i++) cur = cur.next;

    head = cur.next;
    cur.next = null;

    return head;
};
}