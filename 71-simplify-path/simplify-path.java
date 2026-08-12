class Solution {
   public String simplifyPath(String path) {
    ArrayDeque<String> st = new ArrayDeque<>();

    for (String part : path.split("/")) {
        if (part.isEmpty() || part.equals(".")) {
            continue;
        }

        if (part.equals("..")) {
            if (!st.isEmpty()) {
                st.pop();
            }
        } else {
            st.push(part);
        }
    }

    StringBuilder ans = new StringBuilder();

    while (!st.isEmpty()) {
        ans.append("/").append(st.removeLast());
    }

    return ans.length() == 0 ? "/" : ans.toString();
}
}