class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            // [a, b] means b -> a
            adj.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {

            if (!visited[i]) {

                if (detectCycle(i, visited, path, adj, order)) {
                    return new int[0];
                }

            }
        }

        // DFS gives reverse topological order
        Collections.reverse(order);

        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }

        return result;
    }


    private boolean detectCycle(
        int node,
        boolean[] visited,
        boolean[] path,
        List<List<Integer>> adj,
        List<Integer> order
    ) {

        visited[node] = true;
        path[node] = true;

        for (int nextNode : adj.get(node)) {

            // Cycle detected
            if (path[nextNode]) {
                return true;
            }

            // Explore unvisited node
            if (!visited[nextNode]) {

                if (detectCycle(
                    nextNode,
                    visited,
                    path,
                    adj,
                    order
                )) {
                    return true;
                }
            }
        }

        // Remove from current DFS recursion path
        path[node] = false;

        // Add after processing all children
        order.add(node);

        return false;
    }
}