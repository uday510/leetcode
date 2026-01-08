class Solution {

    private final static Map<Character, Character> mappings = new HashMap<>();

    static {
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');     
    }

    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (!mappings.containsKey(ch)) {
                st.push(ch);
            } else {
                if (st.isEmpty() || mappings.get(ch) != st.peek()) return false;
                
                st.pop();
            }
        }

        return st.isEmpty();
    }
}