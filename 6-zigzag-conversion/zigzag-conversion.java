class Solution {
    public String convert(String s, int numRows) {
        List<Character>[] list = new ArrayList[numRows];
        if(numRows == 1) return s;
        for(int i = 0; i < numRows; i ++) {
            list[i] = new ArrayList<>();
        }
        int curRow = 0;
        boolean downDir = true;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            list[curRow].add(curChar);
            if (downDir) {
                if (curRow < numRows - 1)
                    curRow++;
                else {
                    curRow--;
                    downDir = false;
                }
            } else {
                if (curRow > 0)
                    curRow--;
                else {
                    curRow++;
                    downDir = true;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            List<Character> curList = list[i];
            for (int j = 0; j < curList.size(); j++) {
                ans.append(curList.get(j));
            }
        }
        return ans.toString();
    }
}