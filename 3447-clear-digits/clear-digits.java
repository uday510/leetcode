class Solution {
    public String clearDigits(String s) {
        
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        // while (!st.isEmpty()) {
        //     sb.append(st.pop());
        // }

        for (char ch :  st) 
            sb.append(ch);

        return sb.toString();
    }
}