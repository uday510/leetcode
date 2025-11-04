class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            res[i] = xSum(i, k, x, nums);
        }

        return res;
    }

    private int xSum(int st, int k, int x, int[] arr) {
        int en = st + k;
        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for (int i = st; i < en; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        

        
        for (Map.Entry<Integer, Integer> es : map.entrySet()) {
            int a = es.getKey(), b = es.getValue();
            pq.offer(new int[] {a, b});
            if (pq.size() > x) pq.poll();
        }


        int sum = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            sum += cur[0] * cur[1];
        }

        return sum;
    }
}