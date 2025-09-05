class Solution {
    public boolean isUgly(int n) {
        if (n < 1) return false;
        int curr = n;

        for (int num : new int[]{2, 3, 5}) {
            while (curr % num == 0) {
                curr /= num;
            }
        }

        return curr == 1;
    }
}