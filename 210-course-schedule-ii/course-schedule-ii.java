class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i ++) adj.add(new ArrayList<>());

        for(int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        boolean[] path = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<Integer> order = new ArrayList<>();

        for(int i = 0; i < numCourses; i ++ ) {
            if(!visited[i]){
                // System.out.printf("i : %d , " ,i);
                if(detectCycle(i , visited , path , adj, order)) return new int[0];
            }
        }
        Collections.reverse(order);
        int[] ans = new int[order.size()];
        for(int i = 0; i < order.size(); i ++) {
            ans[i] = order.get(i);
        }
        return ans;

    }

    private boolean detectCycle(int node, boolean[] visited , boolean[] path , List<List<Integer>> adj, List<Integer> order) {
        visited[node] = path[node] = true;

        List<Integer> neighbors = adj.get(node);
        for(int nextNode : neighbors) {
            // if(visited[nextNode]) return true;
            if(!visited[nextNode] && detectCycle(nextNode , visited , path , adj,order)) return true;
            if(path[nextNode]) return true;
        }
        path[node] = false;
        order.add(node);
        return false;
    }
}