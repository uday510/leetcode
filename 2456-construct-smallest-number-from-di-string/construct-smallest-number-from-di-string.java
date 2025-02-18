class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int idx = 0; idx <= pattern.length(); ++idx) {
            stack.push(idx + 1);

            if (idx == pattern.length() || pattern.charAt(idx) == 'I') {
                 while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        return result.toString();
    }
}