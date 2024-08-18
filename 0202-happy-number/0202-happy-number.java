class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int num = n;
        
        while (num > 1 && !seen.contains(num)) {
            seen.add(num);
            num = getSum(num);
        }
        return num == 1;
    }
    private int getSum(int num) {
        int sum = 0;
        
        while (num > 0) {
            int val = num % 10;
            sum += val*val;
            num /= 10;
        }
        return sum;
    }
}