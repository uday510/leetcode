class Solution {
    public int minInsertions(String s) {
        int open = 0, mn = 0, n = s.length();
        char c;
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);

            if (c == '(') {
                open++;
            } else {
               if (open > 0) {
                    open--;
               } else {
                    mn++;
               }

               if (i < n - 1 && s.charAt(i + 1) == ')') {
                 i++;
                } else {
                    mn++;
                }
            }
        }

        System.out.println(open);

        return mn + (open * 2);
    }
}