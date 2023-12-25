class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int i = 0;
        int j = 0;
        int N = fruits.length;
        int maxFruitsCollected = 0;
        
        for (; j < N; ++j) {
            basket.put(fruits[j], basket.getOrDefault(fruits[j], 0) + 1);
            while (i < N && basket.size() > 2) {
                basket.put(fruits[i], basket.get(fruits[i])-1);
                if (basket.get(fruits[i]) == 0) {
                    basket.remove(fruits[i]);
                }
                i++;
            }
            int currFruitsCollected = (j - i + 1);
            maxFruitsCollected = Math.max(maxFruitsCollected, currFruitsCollected);
        }
        return maxFruitsCollected;
    }
}