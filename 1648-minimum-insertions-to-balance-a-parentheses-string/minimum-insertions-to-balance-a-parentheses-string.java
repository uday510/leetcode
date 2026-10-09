class Solution {
    public int minInsertions(String s) {
        int ops = 0, mn = 0, n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                ops++;
            } else {
               if (ops > 0) {
                    ops--;
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

        return mn + (ops * 2);
    }
}