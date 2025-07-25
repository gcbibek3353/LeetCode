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

function reverseKGroup(head: ListNode | null, k: number): ListNode | null {
    
     let temp = head;

    // Initialize a pointer to track the
    // last node of the previous group
    let prevLast = null;

    // Traverse through the linked list
    while (temp !== null) {
        // Get the Kth node of the current group
        let kThNode = getKthNode(temp, k);

        // If the Kth node is NULL
        // (not a complete group)
        if (kThNode === null) {
            // If there was a previous group,
            // link the last node to the current node
            if (prevLast) {
                prevLast.next = temp;
            }

            // Exit the loop
            break;
        }

        // Store the next node
        // after the Kth node
        let nextNode = kThNode.next;

        // Disconnect the Kth node
        // to prepare for reversal
        kThNode.next = null;

        // Reverse the nodes from
        // temp to the Kth node
        reverseLinkedList(temp);

        // Adjust the head if the reversal
        // starts from the head
        if (temp === head) {
            head = kThNode;
        } else {
            // Link the last node of the previous
            // group to the reversed group
            prevLast.next = kThNode;
        }

        // Update the pointer to the
        // last node of the previous group
        prevLast = temp;

        // Move to the next group
        temp = nextNode;
    }

    // Return the head of the
    // modified linked list
    return head;
};

// Function to get the Kth node from
// a given position in the linked list
function getKthNode(temp, k) {
    // Decrement K as we already
    // start from the 1st node
    k -= 1;

    // Decrement K until it reaches
    // the desired position
    while (temp !== null && k > 0) {
        // Decrement k as temp progresses
        k--;

        // Move to the next node
        temp = temp.next;
    }

    // Return the Kth node
    return temp;
}

// Function to reverse the linked list
function reverseLinkedList(head) {
    let prev = null;
    let current = head;
    let next = null;

    while (current !== null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }

    head = prev;
}