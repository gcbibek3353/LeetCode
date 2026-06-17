class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        for(int i = 0; i < spells.length; i ++) {
            int potionIndex = getPotionIndex(spells[i], potions , success);
            int curAns = potions.length - potionIndex;
            pairs[i] = curAns;
        }       
        return pairs;
    }

    private int getPotionIndex(int spellStrength, int[] potions , long success) {
        int l = 0;
        int r = potions.length - 1;
        int ans = potions.length;
        while(l <= r) {
            int m = l + (r - l) / 2;
            long pairStrength = (long) potions[m] * spellStrength;
            if(pairStrength < success) l = m + 1;
            else {
                ans = m;
                r = m - 1;
            }
        }
        return ans;
    }
}