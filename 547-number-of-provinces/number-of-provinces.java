class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int ans = 0;

        for(int i = 0; i < n; i ++){
            if(!isVisited[i]){
                ans ++;
                dfs(i , isConnected , isVisited);
            }
        }
        return ans;
    }

    private void dfs(int i , int[][] isConnected , boolean[] isVisited){
        if(isVisited[i]) return;
        isVisited[i] = true;
        int n = isConnected.length;
        for(int j = 0; j < n; j ++) {
            if(!isVisited[j] && isConnected[i][j] == 1) dfs(j,isConnected , isVisited);
        }
    }

}