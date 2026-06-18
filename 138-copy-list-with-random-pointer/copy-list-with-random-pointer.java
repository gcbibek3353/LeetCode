/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node , Node> mp = new HashMap<>();
        Node curNode = head;
        while(curNode != null) {
            Node newNode = new Node(curNode.val);
            mp.put(curNode , newNode);
            curNode = curNode.next;
        }

        curNode = head;
        while(curNode != null) {
            Node newNextNode = mp.get(curNode.next);
            Node randomNextNode = mp.get(curNode.random);
            Node nextNode = mp.get(curNode);
            nextNode.next = newNextNode;
            nextNode.random = randomNextNode;
            curNode = curNode.next;
        }

        return mp.get(head);
    }
}