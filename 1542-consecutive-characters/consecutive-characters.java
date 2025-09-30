class Solution {
    public int maxPower(String s) {
      int max = 0, n = s.length();

      for (int i = 0; i < n; i++) {
        int j = i;
        while (j < n && s.charAt(i) == s.charAt(j)) j++;
        max = Math.max(max, j - i);
      }

      return max;
    }
}