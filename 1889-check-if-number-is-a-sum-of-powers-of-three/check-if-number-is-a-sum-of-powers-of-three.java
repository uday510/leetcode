class Solution {
    public boolean checkPowersOfThree(int n) {
        int num = n;

        while (num > 0) {
            if (num % 3 == 2) return false;
            num /= 3;
        }

        return true;
    }
}