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

function getIntersectionNode(headA: ListNode | null, headB: ListNode | null): ListNode | null {
    let set = new Set<ListNode>();
    let cur = headA;
    while (cur !== null) {
        set.add(cur);
        cur = cur.next;
    }
    cur = headB;
    while (cur !== null) {
        if( set.has(cur)) return cur;
        cur = cur.next;
    }
    return null;
};