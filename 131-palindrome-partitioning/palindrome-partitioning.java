class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        partitionHelper(s, 0, path, res);

        return res;
    }

    private void partitionHelper(String s, int index, List<String> path, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                partitionHelper(s, i + 1, path, res);
                path.remove(path.size() - 1); // Backtrack
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}