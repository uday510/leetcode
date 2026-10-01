class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> st = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                st.push(c);
            } else {
                if (st.isEmpty() || map.get(c) != st.peek()) {
                    return false;
                }
                st.pop();
            }
        }
        
        return st.isEmpty();
    }
}