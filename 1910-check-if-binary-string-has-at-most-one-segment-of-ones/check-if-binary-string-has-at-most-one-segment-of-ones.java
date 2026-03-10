class Solution {
    public boolean checkOnesSegment(String s) {
        int segmentsCount = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(i == 0 && s.charAt(i) == '1') segmentsCount ++;
            else if(i != 0 && s.charAt(i) == '1' && s.charAt(i - 1) != '1') segmentsCount ++;
        }
        return (segmentsCount <= 1);
    }
}