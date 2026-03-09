class Solution {
    public int minOperations(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i ++){
            char expectedChar = (i % 2 == 0) ? '0' : '1';
            char actualChar = s.charAt(i);
            if(expectedChar == actualChar) count ++;
        }
        return Math.min(count , s.length() - count);
    }
}