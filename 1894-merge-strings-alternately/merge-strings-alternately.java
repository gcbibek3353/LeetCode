class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder word = new StringBuilder();
        boolean word1Turn = true;
        int i = 0;
        int j = 0;
        while(i < word1.length() && j < word2.length()) {
            if(word1Turn){
                word.append(word1.charAt(i ++));
                word1Turn = false;
            }
            else{
                word.append(word2.charAt(j ++));
                word1Turn = true;
            }
        }
        while(i < word1.length()) word.append(word1.charAt(i ++));
        while(j < word2.length()) word.append(word2.charAt(j ++));
        return word.toString();
    }
}