class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            int curI = i;

            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(curI) != needle.charAt(j)) break;
                curI++;
            }

            if (j == needle.length()) return i;
        }
        return -1;
    }
}
