class Solution {
    public char findKthBit(int n, int k) {
        return dfs(n, k).charAt(k - 1);
    }
    private String dfs(int n, int k) {
        if (n == 1) {
            return "0";
        }

        String str = dfs(n - 1, k);
        return STR."\{str}1\{reverse(invert(str))}";
    }
    private String invert(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
     private String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}