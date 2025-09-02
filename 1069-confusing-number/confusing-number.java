class Solution {
    static Map<Integer, Integer> map = new HashMap<>();
    static {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
    }
    
    public boolean confusingNumber(int n) {
        int reversed = 0;
        int original = n;

        while (original > 0) {
            int digit = original % 10;
            if (!map.containsKey(digit)) return false;
            reversed = reversed * 10 + map.get(digit);
            original /= 10;
        }

        return reversed != n;
    }
}