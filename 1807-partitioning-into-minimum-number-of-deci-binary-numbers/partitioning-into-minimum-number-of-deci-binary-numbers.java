class Solution {
    public int minPartitions(String n) {
       int ans = 0;
       for(int i : n.toCharArray()){
        ans = Math.max(ans , i - '0');
       }
       return ans;
    }
}