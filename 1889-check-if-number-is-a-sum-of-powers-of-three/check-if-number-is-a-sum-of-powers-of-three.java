class Solution {
    public boolean checkPowersOfThree(int n) {
        return (n == 0 || ( n % 3 != 2 && checkPowersOfThree(n / 3)));
    }
}