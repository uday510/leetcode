class Solution {
    public String reorganizeString(String s) {
         int[] arr = new int[128];
        
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        
        for (int i = 97; i < 128; ++i) {
            if (arr[i] == 0) continue;
            pq.offer(new int[] {i, arr[i]});
            System.out.println((char) i + " " + arr[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first =  pq.poll();
            if (sb.isEmpty() || sb.charAt(sb.length() - 1) != first[0]) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                   pq.offer(first);
                }
            } else {
                if (pq.isEmpty()) return "";
                int[] second =  pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.offer(second);
                }
                pq.offer(first);
            }
        }
        
        return sb.toString();
    }
}