class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i ++) graph.add(new ArrayList<>());
        
        for(int[] prerequisite : prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i = 0; i < numCourses; i ++) {
            if(!visited[i] && cycleDetect(i, graph, visited, path)) return false;
        }
        return true;
    }

    private boolean cycleDetect(int node, List<List<Integer>> adj, boolean[] vis, boolean[] path) {
        vis[node] = path[node] = true;

        for (int next : adj.get(node))
            if (!vis[next] && cycleDetect(next, adj, vis, path)) return true;
            else if (path[next]) return true;
            
        path[node] = false;
        return false;
    }

    // private boolean cycleDetect(int j, boolean[] visited , boolean[] path, List<List<Integer>> graph) {
    //     visited[j] = path[j] = true;
    //     List<Integer> neighbors = graph.get(j);
    //     for(int i = 0; i < neighbors.size(); i ++){
    //         if(!visited[neighbors.get(i)] && cycleDetect(i , visited, path , graph) ) return true;
    //         if(path[neighbors.get(i)]) return true;
    //         // if(cycleDetect(i , visited, path , graph)) return true;
    //     }
    //     path[j] = false;
    //     return false;
    // }


}