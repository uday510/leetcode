class Solution {
    public int findCenter(int[][] edges) {
         Map<Integer, Integer> map = new HashMap<>();

        for (int[] edge : edges) {
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }

        int max = 0;
        int centerNode = 0;

        for (Map.Entry<Integer, Integer> keySet : map.entrySet()) {
           if (keySet.getValue() > max) {
               centerNode = keySet.getKey();
               max = keySet.getValue();
           }
        }
    
        return centerNode;
    }
}