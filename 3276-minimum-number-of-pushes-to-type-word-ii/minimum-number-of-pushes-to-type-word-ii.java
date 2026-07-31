class Solution {
    public int minimumPushes(String word) {
        
        var cnts = new HashMap<Character, Integer>();
        for (char c : word.toCharArray())
            cnts.merge(c, 1, Integer::sum);
 
        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        cnts.values().forEach(pq::offer);

        int idx = 0, res = 0;
        while (!pq.isEmpty()) 
            res += (idx++/8 + 1) * pq.poll();

        return res;   
    }
}
