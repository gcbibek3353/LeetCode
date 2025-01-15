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

function removeNthFromEnd(head: ListNode | null, n: number): ListNode | null {
    if(n === 0) return head;
    if(head === null || head.next === null) return null;
    let count = 0;
    let curHead = head;
    while(curHead != null){
        count ++;
        curHead = curHead.next;
    }
    let requiredNodePos = count - n;
    if(requiredNodePos <= 0) return head.next;
    curHead = head;
    for(let i = 1; i < requiredNodePos; i ++){
        curHead = curHead.next;
    }
    curHead.next = curHead.next.next;
    return head;
};