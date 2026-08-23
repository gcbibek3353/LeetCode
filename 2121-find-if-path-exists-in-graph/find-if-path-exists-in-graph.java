class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> al = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] edge : edges) {
            al.get(edge[0]).add(edge[1]);
            al.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        visited[source] = true;

        return dfs(source, destination, al, visited);
    }

    private boolean dfs(int s, int d, List<List<Integer>> al, boolean[] visited) {
        if (s == d) return true;

        for (int neighbor : al.get(s)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;

                if (dfs(neighbor, d, al, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}