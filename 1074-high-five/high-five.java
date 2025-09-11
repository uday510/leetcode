class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int ids = 0;

        for (int[] i : items) {
            int id = i[0], scr = i[1];

            if (!map.containsKey(id)) {
                map.put(id, new PriorityQueue<>((a, b) -> a - b));
                ids++;
            }

            var pq = map.get(id);
            
            pq.offer(scr);
            if (pq.size() > 5) pq.poll();
        }

        int[][] res = new int[ids][2];
        int idx = 0;

        for (var kv : map.entrySet()) {
            int k = kv.getKey();

            int sum = 0;

            PriorityQueue<Integer> v = kv.getValue();
            for (int c : v) sum += c;
            
            res[idx][0] = k;
            res[idx++][1] = sum / v.size();
        }

        return res;
    }
}