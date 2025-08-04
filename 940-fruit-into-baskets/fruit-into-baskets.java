class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, n = fruits.length;
        int max = 0;

        int[] basket = new int[(int)1e5];
        int unique = 0;
        while (r < n) {
            if (basket[fruits[r]]++ == 0) unique++;

            while (unique > 2) {
               if (--basket[fruits[l++]] == 0) unique--;
            }

            max = Math.max(max, r++ - l + 1);
        }

        return max;
    }
}