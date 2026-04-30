class Solution {
    public String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        String ans = "";
        int carry = 0;
        while(alen > 0 || blen > 0 || carry != 0) {  // Fix 1: use > 0 instead of != 0
            int curSum = carry;  // Fix 2: include carry in sum
            if(alen > 0) curSum += a.charAt(alen - 1) - '0';  // Fix 3: better char conversion
            if(blen > 0) curSum += b.charAt(blen - 1) - '0';
            
            ans = (curSum % 2) + ans;  // Fix 4: bit is sum mod 2
            carry = curSum / 2;  // Fix 5: carry is sum div 2
            
            alen--;
            blen--;
        }
        return ans;
    }
}