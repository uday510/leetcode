class Solution {
    public String decodeString(String s) {
        int n = s.length();
        var st = new Stack<String>();
        var nums = new Stack<Integer>();
        var res = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num*10 + (c - '0');
            } else if (c == '[') {
                nums.push(num);
                num = 0;

                st.push(res.toString());
                res.setLength(0);
            } else if (c == ']') {
                var str = new StringBuilder(st.pop());
                int times = nums.pop();
                
                res = str.append(res.toString().repeat(times));
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}