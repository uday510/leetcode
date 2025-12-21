class Solution {
    public int minDeletionSize(String[] strs) {
        int cnt = 0, n = strs.length;
        int cols = strs[0].length();

        String[] cur1 = new String[n];
        for (int col = 0; col < cols; col++) {
            
            String[] cur2 = Arrays.copyOf(cur1, n);
            for (int i = 0; i < n; i++) {
                cur2[i] += strs[i].charAt(col);
            }

            if (isSorted(cur2)) {
                cur1 = cur2;
            } else {
                cnt++;
            }
        }


        return cnt;
    }

    private boolean isSorted(String[] strs) {

        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i].compareTo(strs[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }
}