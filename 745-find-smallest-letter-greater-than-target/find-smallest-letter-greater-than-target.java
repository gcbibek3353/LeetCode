class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        Character ans = letters[0];
        int l = 0;
        int r = letters.length - 1;
        while(l <= r) {
            int mid = l + (( r - l) / 2);
            if(letters[mid] < target) l = mid + 1;

                else if (letters[mid] == target) l = mid + 1;
            else {
                ans = letters[mid];
                r = mid - 1;
            }
        }
        return ans;
    }
}