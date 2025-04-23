class Solution {
    public String reorganizeString(String s) {
        int[] cnt = new int[128];

        for (char ch : s.toCharArray()) cnt[ch]++;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        for (int i = 0; i < 128; ++i) {
            if (cnt[i] == 0) continue;

            pq.offer(new int[] {i, cnt[i]});

            if (cnt[i] > (s.length() + 1)) return "";
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] first = pq.poll();

            if (sb.isEmpty() || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) pq.offer(first);
            } else {
                if (pq.isEmpty()) return "";
                int[] second = pq.poll();
                sb.append((char) second[0]);

               if (--second[1] > 0) pq.offer(second);

               pq.offer(first);
            }
        }
        
        return sb.toString();
    }
}