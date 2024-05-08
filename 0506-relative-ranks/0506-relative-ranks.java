class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.val, o1.val));
        
        for (int i = 0; i < score.length; ++i) {
            pq.offer(new Pair(score[i], i));
        }
        String[] result = new String[score.length];
        
        int index = 1;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            System.out.print(p.val + " " + p.idx + ", ");
            
            if (index == 1) {
                result[p.idx] = "Gold Medal";
            } else if (index == 2) {
                result[p.idx] = "Silver Medal";
            } else if (index == 3) {
                result[p.idx] = "Bronze Medal";
            } else {
                result[p.idx] = Integer.toString(index);
            }
            index++;
            
        }
        return result;
    }
}
class Pair {
        int val;
        int idx;
    
        Pair (int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }