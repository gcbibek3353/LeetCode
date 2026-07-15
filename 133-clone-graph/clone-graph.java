class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> mp = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Set<Node> visited2 = new HashSet<>();

        dfs(node, visited, mp);
        setNeighbours(node, visited2, mp);

        return mp.get(node);
    }

    private void setNeighbours(Node head, Set<Node> visited,
                               Map<Node, Node> mp) {

        if (head == null || visited.contains(head)) return;

        visited.add(head);

        List<Node> newneighbors = new ArrayList<>();

        for (Node nei : head.neighbors) {
            newneighbors.add(mp.get(nei));
            setNeighbours(nei, visited, mp);
        }

        mp.get(head).neighbors = newneighbors;
    }

    private void dfs(Node head, Set<Node> visited,
                     Map<Node, Node> mp) {

        if (head == null || visited.contains(head)) return;

        visited.add(head);
        mp.put(head, new Node(head.val));

        for (Node nei : head.neighbors) {
            dfs(nei, visited, mp);
        }
    }
}