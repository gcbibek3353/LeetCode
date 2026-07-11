class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int num : hand){
            treeMap.put(num , treeMap.getOrDefault(num , 0) + 1);
        }

        int count = hand.length / groupSize;
        while(count > 0) {
            int lowestElm = treeMap.firstKey();
            for(int i = 0; i < groupSize; i ++){
                int curRequiredNum = lowestElm + i;
                if(!treeMap.containsKey(curRequiredNum)) return false;
                int newFreq = (treeMap.get(curRequiredNum) - 1);
                if(newFreq == 0) treeMap.remove(curRequiredNum);
                else treeMap.put(curRequiredNum , newFreq);
            }
            count --;
        }
        return treeMap.size() == 0;
    }
}