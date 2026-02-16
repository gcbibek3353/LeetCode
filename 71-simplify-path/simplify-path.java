class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        StringBuilder ans = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
    
        for(String curStr : strs) {
            if(curStr.equals("") || curStr.equals(".")) continue;
            else if(curStr.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(curStr);
        }
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
            ans.insert(0,"/" + stack.pop());
        }
        return ans.toString();
    }
}