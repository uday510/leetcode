class Solution {
    public String decodeString(String s) {
        int n = s.length();
        var st = new Stack<String>();
        var nums = new Stack<Integer>();
        var tmp = new StringBuilder();
        int num = 0;
        
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                nums.push(num);
                num = 0;
                
                st.push(tmp.toString());
                tmp.setLength(0);
            } else if (c == ']') {
                int repeat = nums.pop();
                StringBuilder str = new StringBuilder(st.pop());
                
                for (int j = 0; j < repeat; ++j) {
                    str.append(tmp);
                }
                
                tmp = str;
            } else {
                tmp.append(c);
            }
        }
        
        return tmp.toString();
    }
}
