/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function reverseList(head: ListNode | null): ListNode | null {
    if (head === null || head.next === null) return head;
    let prevNode = null;
    let cur = head;

    while (cur !== null) {
        let temp = cur;
        cur = cur.next;
        temp.next = prevNode;
        prevNode = temp;
    }
    return prevNode;

};