class Solution {
    public int[][] highFive(int[][] items) {
       Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
       int k = 5;

       for (int[] i : items) {
            int id = i[0], src = i[1];

            if (!map.containsKey(id)) {
                map.put(id, new PriorityQueue<>((a, b) -> a - b));
            }

            var pq = map.get(id);
            pq.offer(src);
            if (pq.size() > k) pq.poll();
       }

       int[][] res = new int[map.size()][2];
       int idx = 0;

       for (var es : map.entrySet()) {
            int key = es.getKey();

            int cur = 0;
            var pq = map.get(key);
            int size = pq.size();

            while (!pq.isEmpty()) {
                cur += pq.poll();
            }
            
            res[idx][0] = key;
            res[idx][1] = cur / size;
            idx++;
       }

       return res;
    }
}