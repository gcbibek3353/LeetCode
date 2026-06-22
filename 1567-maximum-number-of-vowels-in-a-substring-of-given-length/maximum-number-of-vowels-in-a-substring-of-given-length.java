class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = 0;
        int curCount = 0;

        for(int i = 0; i < s.length(); i ++) {
            if(isVowel(s.charAt(i))) curCount ++;
            if(i - k >= 0){
                if(isVowel(s.charAt(i - k))) curCount --;
            }
            if(i - (k-1) >= 0){
                maxCount = Math.max(maxCount , curCount);
            }
        }
        return maxCount;
    }
    private boolean isVowel(Character c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        else return false;
    }
}