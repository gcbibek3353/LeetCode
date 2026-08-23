class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = numCourses;
        for(int i = 0; i < numCourses; i ++) {
            adj.add(i , new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        
        for(int i = 0; i < adj.size(); i ++) {
            if(!visited[i] && detectCycle(i , path , visited , adj)) return false;
        }
        return true;
    }

    private boolean detectCycle(int j , boolean[] path , boolean[] visited , List<List<Integer>> adj) {
        path[j] = visited[j] = true;
        List<Integer> neigh = adj.get(j);
        for(int i = 0; i < neigh.size(); i ++) {
            if(path[neigh.get(i)]) return true;
            if(!visited[neigh.get(i)] && detectCycle(neigh.get(i) , path , visited , adj)) return true;
        }
        path[j] = false;
        return false;
    }
}