class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int mismatch = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    ++mismatch;
                } else {
                    stack.pop();
                }
            }
        }
        return mismatch + stack.size();
    }
}