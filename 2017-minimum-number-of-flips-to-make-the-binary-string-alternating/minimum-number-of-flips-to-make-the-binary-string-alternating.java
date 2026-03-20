class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String doubled = s + s;
        int differenceCount = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < doubled.length(); i ++) {
            char expectedChar = (i % 2 == 0) ? '0' : '1';
            char curChar = doubled.charAt(i);
            if(expectedChar != curChar) differenceCount ++;

            if(i >= n){
                char previouslyExpectedChar = ((i - n) % 2 == 0) ? '0' : '1';
                char previousActualChar = doubled.charAt(i - n);
                if(previouslyExpectedChar != previousActualChar) differenceCount --;
            }

            if(i >= n - 1){
                int minDifference = Math.min(differenceCount , n - differenceCount);
                ans = Math.min(ans , minDifference);
            }

        }
        return ans;
    }
}