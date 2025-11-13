class Solution {
    public int maxOperations(String s) {
        int n = s.length(), cnt = 0;
        int ones = 0;

        for (int i = 0; i < n;) {
            if (s.charAt(i) == '1') {
                ones++;
                i++;
            } else {
                int j = i;
                while (j < n && s.charAt(j) == '0') {
                    j++;
                }
                cnt += ones;
                i = j;
            }
        }

        return cnt;
    }
}