class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Set<Integer> visited = new HashSet<>();
        int noOfProvince = 0;

        for(int i = 0; i < isConnected.length; i ++) {
            if(visited.contains(i)) continue;
            noOfProvince ++;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            while(!q.isEmpty()) {
                int size = q.size();
                for(int j = 0; j < size; j ++) {
                    int topCity = q.poll();
                    for(int k = 0; k < n; k ++) {
                        if(isConnected[topCity][k] == 1 && topCity != k && !visited.contains(k)){
                            visited.add(k);
                            q.offer(k);
                        } 
                    }
                }
            }
        }
        return noOfProvince;
    }
}