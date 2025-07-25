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

function rotateRight(head: ListNode | null, k: number): ListNode | null {
    if (head === null || head.next === null) return head;
    let length = 1;
    let cur = head;
    while (cur.next !== null) {
        cur = cur.next;
        length++;
    }
    cur.next = head;
    let cutPosition = length - (k % length);

    cur = head;
    for (let i = 1; i < cutPosition; i++) cur = cur.next;

    head = cur.next;
    cur.next = null;

    return head;
};