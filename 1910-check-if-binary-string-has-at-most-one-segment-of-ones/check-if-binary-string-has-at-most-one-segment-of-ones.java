class Solution {
    public boolean checkOnesSegment(String s) {
        int segmentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '1')
                    segmentCount++;
            } else if (s.charAt(i) == '1' && s.charAt(i - 1) != '1')
                segmentCount++;
        }
        
        
        return segmentCount <= 1;
    }
}