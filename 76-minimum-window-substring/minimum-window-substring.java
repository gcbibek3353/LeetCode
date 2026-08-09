class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
    for (char c : t.toCharArray()) 
        need.put(c, need.getOrDefault(c, 0) + 1);

    Map<Character, Integer> have = new HashMap<>();
    int formed = 0;
    int i = 0;
    int minLen = Integer.MAX_VALUE;
    String result = "";

    for (int j = 0; j < s.length(); j++) {
        char c = s.charAt(j);
        have.put(c, have.getOrDefault(c, 0) + 1);
        
        if (need.containsKey(c) && have.get(c).equals(need.get(c)))
            formed++;

        while (formed == need.size()) {
            if (j - i + 1 < minLen) {
                minLen = j - i + 1;
                result = s.substring(i, j + 1);
            }
            char left = s.charAt(i);
            have.put(left, have.get(left) - 1);
            if (need.containsKey(left) && have.get(left) < need.get(left))
                formed--;
            i++;
        }
    }
    return result;
    }
}