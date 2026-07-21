class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count frequencies
        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        // Check if both strings contain the same set of characters
        for (int i = 0; i < 26; i++) {
            if(freq1[i] == 0 && freq2[i] == 0) continue;
            if(freq1[i] == 0 || freq2[i] == 0) return false;
        }

        // Sort frequency arrays
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        // Compare sorted frequencies
        return Arrays.equals(freq1, freq2);
    }
}