class Solution {
    public char findKthBit(int n, int k) {
        return dfs(n, k).charAt(k-1);
    }
    private String dfs(int n, int k) {
        if (n == 1) 
            return "0";

        String str = dfs(n - 1, k);

        return str + "1" + reverse(invert(str));
    }
    private String invert(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            sb.append (c == '1' ? 0 : 1);
        }
        return sb.toString();
    }
    private String reverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }
}