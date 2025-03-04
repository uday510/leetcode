class Solution {
    public boolean checkPowersOfThree(int n) {
        int num = n;

        while (num > 0 && num % 3 != 2) num /= 3;
        
        return num % 3 != 2;
    }
}