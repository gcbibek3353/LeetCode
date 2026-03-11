class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        if(n == 1) return 0;
        int digitCount = 0;
        for(int i = 0; i < 32; i ++){
            int mask = 1 << i;
            if((mask & n) != 0) digitCount = i + 1;
        }

        int mask = (1 << digitCount) - 1;
        return ~n & mask;
    }
}