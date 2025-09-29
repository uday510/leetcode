class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int k = 5;

        for (int[] i : items) {
            int id = i[0], sc = i[1];

            PriorityQueue<Integer> scores = map.computeIfAbsent(id,
             _ -> new PriorityQueue<Integer>((a, b) -> Integer.compare(a, b)));


            scores.offer(sc);
           if (scores.size() > k) scores.poll();
        }

        int[][] res = new int[map.size()][2];
        int i = 0;

        for (var es : map.entrySet()) {
            int id = es.getKey();
            int sum = 0;
            PriorityQueue<Integer> scores = es.getValue();
            int size = scores.size();

            // while (!scores.isEmpty()) sum += scores.poll();
            for (int scr : scores) sum += scr;

            res[i][0] = id;
            res[i++][1] = sum / size;
        }

        return res;
    }
}