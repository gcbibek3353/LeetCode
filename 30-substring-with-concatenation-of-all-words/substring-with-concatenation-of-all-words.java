class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        Map<String, Integer> original = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        int wordSize = words[0].length();
        int totalWords = words.length;
        int totalLength = wordSize * totalWords;

        for (String str : words) {
            original.put(str, original.getOrDefault(str, 0) + 1);
        }

        // We only need to start from wordSize different offsets
        for (int offset = 0; offset < wordSize; offset++) {

            int start = offset;
            int wordCount = 0;

            Map<String, Integer> curMap = new HashMap<>();

            for (int end = offset; end + wordSize <= s.length(); end += wordSize) {

                String curWord = s.substring(end, end + wordSize);

                // Word is not present in words -> reset window
                if (!original.containsKey(curWord)) {
                    curMap.clear();
                    wordCount = 0;
                    start = end + wordSize;
                    continue;
                }

                curMap.put(
                    curWord,
                    curMap.getOrDefault(curWord, 0) + 1
                );

                wordCount++;

                // Too many occurrences of curWord
                while (curMap.get(curWord) > original.get(curWord)) {

                    String firstWindowWord =
                        s.substring(start, start + wordSize);

                    curMap.put(
                        firstWindowWord,
                        curMap.get(firstWindowWord) - 1
                    );

                    start += wordSize;
                    wordCount--;
                }

                // We have exactly all words
                if (wordCount == totalWords) {
                    ans.add(start);

                    // Move window forward by one word
                    String firstWindowWord =
                        s.substring(start, start + wordSize);

                    curMap.put(
                        firstWindowWord,
                        curMap.get(firstWindowWord) - 1
                    );

                    start += wordSize;
                    wordCount--;
                }
            }
        }

        return ans;
    }
}