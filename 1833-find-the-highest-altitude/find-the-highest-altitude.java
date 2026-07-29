class Solution {
    public int largestAltitude(int[] gain) {
        int curAltitude = 0;
        int maxAltitude = curAltitude;
        for(int diff : gain){
            curAltitude += diff;
            maxAltitude = Math.max(maxAltitude , curAltitude);
        }
        return maxAltitude;
    }
}