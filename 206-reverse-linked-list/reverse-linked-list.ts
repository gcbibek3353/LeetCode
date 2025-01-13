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
    if(head === null) return null;
    if(head.next === null) return head;
    let curNode = head;
    let prevNode = null;
    while(curNode != null){
        let thisNode = curNode;
         curNode = curNode.next;
        thisNode.next = prevNode;
        prevNode = thisNode;
    }
    return prevNode;
};