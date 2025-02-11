class Solution {
    public String removeOccurrences(String s, String part) {
        
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            st.push(ch);

            if (valid(st, part)) {
                for (char ch2 : part.toCharArray()) {
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }

        return sb.toString();
    }

    private boolean valid(Stack<Character> st, String part) {

        Stack<Character> temp = new Stack<>();
        temp.addAll(st);

        for (int idx = part.length() - 1; idx > -1; --idx) {
            if (temp.isEmpty() || part.charAt(idx) != temp.peek()) 
                return false;

            temp.pop();
        }

        return true;
    }
}