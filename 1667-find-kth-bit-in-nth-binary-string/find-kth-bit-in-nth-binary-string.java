class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1) return '0';
        int num = (1 << n) - 1;
        int mid = num / 2 + 1;
        if(mid == k) return '1';
        else if (k < mid) return findKthBit(n - 1 , k);
        else {
            char ch = findKthBit(n - 1 , num - k + 1);
            return (ch == '0') ? '1' : '0';
        }
    }
}