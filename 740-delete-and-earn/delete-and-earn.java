class Solution {

    Map<Integer, Integer> map;
    Map<Integer, Integer> cache;

    public int deleteAndEarn(int[] nums) {
        int n = -1;
        map = new HashMap<>();
        cache = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
            n = Math.max(n, num);
        }

        return dfs(n);
    }

    private int dfs(int n) {
        if (n < 0) return 0;

        if (cache.containsKey(n)) {
            System.out.println("cached");
            return cache.get(n);
        }

        int pick = map.getOrDefault(n, 0) + dfs(n - 2);
        int dont = dfs(n - 1);

        int cur = Math.max(pick, dont);
        cache.put(n, cur);

        return cur;
    }
}