class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > ch) {
                k--;
                stack.pollLast();
            }

            stack.offerLast(ch);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) sb.append(stack.pollFirst());

        while (!sb.isEmpty() && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.isEmpty() ? "0" : sb.toString();
    }
}