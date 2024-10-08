class Solution {
    public int minSwaps(String s) {
       int stackSize = 0;
       int unbalanced = 0;

       for (char c : s.toCharArray()) {
            if (c == '[') {
                ++stackSize;
            } else {
                if (stackSize > 0) {
                    --stackSize;
                } else {
                    ++unbalanced;
                }
            }
       }
       return (unbalanced + 1) / 2;
    }
}