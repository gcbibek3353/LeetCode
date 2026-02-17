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
        Node curHead = head;
        while(curHead != null){
            Node newNode = new Node(curHead.val);
            mp.put(curHead,newNode);
            curHead = curHead.next;
        }
        curHead = head;
        while(curHead != null){
            Node curNode = mp.get(curHead);
            if(curHead.next == null) curNode.next = null;
            else curNode.next = mp.get(curHead.next);
            curNode.random = mp.get(curHead.random);
            curHead = curHead.next;
        }
        return mp.get(head);
    }
}