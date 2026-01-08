class Solution {
    public String simplifyPath(String path) {
        
        String[] paths = path.split("/");
        Deque<String> st = new ArrayDeque<>();

        for (String p : paths) {

            if (p.isEmpty() || p.equals(".")) continue;

            if (p.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else {
                st.push(p);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (st.isEmpty()) return "/";

        while (!st.isEmpty()) {
            sb.append("/").append(st.pollLast());
        }

        return sb.toString();
    }
}