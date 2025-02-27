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

function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
    if(list1 === null) return list2;
    if(list2 === null) return list1;
    let list : ListNode = new ListNode();
    if(list1.val>list2.val){
        list = list2;
        list2 = list2.next;
    }else{
        list = list1;
        list1 = list1.next;
        }
    let head = list;
    let head1 = list1;
    let head2 = list2;
    while(head1 !== null && head2 !== null){
        if(head1.val <= head2.val){
            head.next = head1;
            head = head1;
            head1 = head1.next;
        }
        else{
            head.next = head2;
            head = head2;
            head2 = head2.next;
        }
    }
    if(head1 === null) head.next = head2;
    else if(head2 === null) head.next = head1;
    return list;
    
};