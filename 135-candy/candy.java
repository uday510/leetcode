class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        int sum = 0;

        Arrays.fill(candies, 1);
        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i-1]) 
                candies[i] = candies[i-1] + 1;
        }
        sum += candies[n-1];
        for (int i = n-2; i > -1; --i) {
            if (ratings[i] > ratings[i+1]) 
                candies[i] = Math.max(candies[i+1]+1, candies[i]);
            sum += candies[i];
        }
        return sum;
    }
}