class Solution {
    public int minimumPushes(String word) {
         Map<Character, Integer> map = new HashMap<>();

       for (char c : word.toCharArray()) {
           map.put(c, map.getOrDefault(c, 0) + 1);
       }

       PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

       pq.addAll(map.values());

       int index = 0;
       int count = 0;

       while (!pq.isEmpty()) {
           count += (index/8 + 1) * pq.poll();
           ++index;
       }
       return count;
    }
}