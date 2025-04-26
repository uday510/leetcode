class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = num.length();

        for (int idx = 0; idx < n; ++idx) {
            char ch = num.charAt(idx);

            while (!stack.isEmpty() && k > 0 && stack.peekLast() > ch) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(ch);
        }

        while (k-- > 0 && !stack.isEmpty()) stack.pollLast();

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) sb.append(stack.pollFirst());

        while (!sb.isEmpty() && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.isEmpty() ?  "0" : sb.toString();
    }
}