class Solution {
    int[] arr = new int[] {1, 7, 30};
    Map<String, Integer> dp = new HashMap<>();

    public int mincostTickets(int[] days, int[] costs) {
        return dfs(0, 0, days, costs);
    }

    private int dfs(int index, int pass, int[] days, int[] costs) {
        if (index >= days.length) {
           return 0;
        }

        String key = index + "_" + pass;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (pass >= days[index]) {
            int result = dfs(index + 1, pass, days, costs);
            dp.put(key, result);
            return result;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; ++i) {
            int newPass = days[index] + arr[i] - 1;
            min = Math.min(min, dfs(index + 1, newPass, days, costs) + costs[i]);
        }

        dp.put(key, min);

        return min;
    }
}