class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;
        int n = fruits.length;
        int max = 0;

        Map<Integer, Integer> basket = new HashMap<>();
        while (r < n) {
            basket.merge(fruits[r], 1, Integer::sum);

            while (l < r && basket.size() > 2) {
                basket.merge(fruits[l], -1, Integer::sum);
                if (basket.get(fruits[l]) == 0) basket.remove(fruits[l]);
                l++;
            }

            int curr = 0;
            for (var E : basket.entrySet()) {
                curr += E.getValue();
            }

            max = Math.max(curr, max);
            r++;
        }

        return max;
    }
}