class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] cnts = new int[n];

        cnts[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) cnts[i] = cnts[i - 1] + 1;
            else cnts[i] = 1;
        }

        int total = cnts[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                cnts[i] = Math.max(cnts[i], cnts[i + 1] + 1);
            }
            total += cnts[i];
        }
        
        return total;
    }
}