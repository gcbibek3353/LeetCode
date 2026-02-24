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
    public Node cloneGraph(Node node) {
        Map<Node , Node> mp = new HashMap<>();
        return dfs(node , mp);
    }

    private Node dfs(Node node , Map<Node , Node> mp) {
        if(node == null) return node;
        if(mp.containsKey(node)) return node;
        List<Node> newNeighbors = new ArrayList<>();
        Node newNode = new Node();
        newNode.val = node.val;
        mp.put(node , newNode);
        List<Node> neighbors = node.neighbors;
        for(int i = 0; i < neighbors.size(); i ++)dfs(neighbors.get(i),mp);
        for(int i = 0; i < neighbors.size(); i ++) newNeighbors.add(mp.get(neighbors.get(i)));
        newNode.neighbors = newNeighbors;
        return newNode;
    }
}