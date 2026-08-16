/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Set<Node> visited = new HashSet<>();
    Map<Node , Node> mp = new HashMap<>();
    public Node cloneGraph(Node node) {
        createDuplicateNodes(node);
        visited.clear();
        setNeighbors(node);
        return mp.get(node);
    }

    private void createDuplicateNodes(Node node) {
        if(node == null || visited.contains(node)) return;
        visited.add(node);
        Node newNode = new Node(node.val);
        mp.put(node , newNode);
        List<Node> neighbors = node.neighbors;
        for(int i = 0; i < neighbors.size(); i ++) {
            createDuplicateNodes(neighbors.get(i));
        }
    }

    private void setNeighbors(Node node) {
        if(node == null || visited.contains(node)) return;
        Node curNode = mp.get(node);
        visited.add(node);
        List<Node> neighbors = node.neighbors;
        for(int i = 0; i < neighbors.size(); i ++) {
            Node curNeighbor = neighbors.get(i);
            // if(!visited.contains(curNeighbor)){
                curNode.neighbors.add(mp.get(curNeighbor));
                setNeighbors(curNeighbor);
            // }
        }
    }
}