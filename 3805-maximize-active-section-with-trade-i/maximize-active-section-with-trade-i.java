class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int oneCount = 0;
        int n = s.length();
        for(char curChar : s.toCharArray()){
            if(curChar == '1') oneCount ++;
        }
        List<Integer> zeroBlocks = new ArrayList<>();
        int i = 0;
        while(i < n) {
            int curSize = 0;
            char curChar = s.charAt(i);
            while(i < n && s.charAt(i) == curChar) {
                curSize ++;
                i ++;
            }
            if(curChar == '0') zeroBlocks.add(curSize);
        }
        if(zeroBlocks.size() < 2) return oneCount;
        int bestGain = 0;
        i = 0;
        for(i = 0; i < zeroBlocks.size() - 1; i ++) {
            bestGain = Math.max(bestGain , zeroBlocks.get(i) + zeroBlocks.get(i + 1));
        }
        return oneCount + bestGain;
    }
}