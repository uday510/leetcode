class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> seen = new HashSet<>();

        while (n > 1 && seen.add(n)) {
            n = sum(n);
        }

        return n == 1;
    }

    private int sum (int n) {
        int cur = 0;
        
        while (n > 0) {
            cur += (n % 10) * (n % 10);
            n /= 10;
        }

        return cur;
    }
}