class Solution {
    public int minOperations(String s) {
        int differenceCount = 0;
        for(int i = 0; i < s.length(); i ++){
            char curCharShouldBe = (i % 2 == 0) ? '0' : '1';
            char curChar = s.charAt(i);
            if(curCharShouldBe != curChar) differenceCount ++;
        }
        return Math.min(differenceCount , s.length() - differenceCount);
    }
}