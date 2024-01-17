class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> wMap = new HashMap<>();
        Map<Integer, Integer> lMap = new HashMap<>();

        List<Integer> winners = new ArrayList<>();
        List<Integer> losers = new ArrayList<>();
    
        for (int[] mat : matches) {
            int w = mat[0];
            int l = mat[1];

            wMap.put(w, wMap.getOrDefault(w, 0)+1);
            lMap.put(l, lMap.getOrDefault(l, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : wMap.entrySet()) {
            int winner = entry.getKey();

            if (!lMap.containsKey(winner)) {
                winners.add(winner);
            }
        }
        for (Map.Entry<Integer, Integer> entry : lMap.entrySet()) {
            int loser = entry.getKey();

            if (lMap.get(loser) == 1) {
                losers.add(loser);
            }
        }

    List<List<Integer>> res = new ArrayList<>();
    
    // winners.sort((o1, o2) -> o1-o2);
    // losers.sort((o1, o2) -> o1-o2);
    Collections.sort(winners);
    Collections.sort(losers);

    res.add(winners);
    res.add(losers);
    return res;

    }
}