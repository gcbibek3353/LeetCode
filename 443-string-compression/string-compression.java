class Solution {
    public int compress(char[] chars) {
        int insertPos = 0;

        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            int curCharCount = 1;

            // Count consecutive occurrences
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                i++;
                curCharCount++;
            }

            // Insert the character
            chars[insertPos++] = curChar;

            // Insert the count only if count > 1
            if (curCharCount > 1) {
                String count = String.valueOf(curCharCount);

                for (int j = 0; j < count.length(); j++) {
                    chars[insertPos++] = count.charAt(j);
                }
            }
        }

        return insertPos;
    }
}