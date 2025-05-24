class Solution {
    public int maxSubstrings(String word) {
        int n = word.length();

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        List<int[]> pq = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (j - i + 1< 4) continue;
                
                char st = word.charAt(i);
                char en = word.charAt(j);

                if (st == en) {
                    pq.add(new int[] {i, j});
                    break;
                }
            }
        }

        pq.sort((a, b) -> a[1] - b[1]);

        int cnt = 0;
        int prev = -1;
        
        for (int i = 0; i < pq.size(); ++i) {
            int[] curr = pq.get(i);
            int st = curr[0], en = curr[1];

            if (st <= prev) continue;

            cnt++;
            prev = en;
        }

        return cnt;
        
    }
}