class Solution {
    public int countTriples(int n) {
        
        int cnt = 0;

        for (int a = 1; a <= n; a++) {

            for (int b = 1; b <= n; b++) {

                int c = (int) Math.sqrt(a * a + b * b + 1.0);
                
                cnt += (c <= n && a * a + b * b == c * c) ? 1 : 0;

            }
        }

        return cnt;
    }
}