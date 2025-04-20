class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int len = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();


        for (int idx = 0; idx < groupSizes.length; ++idx) {
            int grp = groupSizes[idx];
            
            map.computeIfAbsent(grp, x -> new ArrayList<>());

            List<Integer> list = map.get(grp);

            list.add(idx);
            if (list.size() == grp) {
                res.add(list);
                map.put(grp, new ArrayList<>());
            } 
        }
        return res;
    }
}


// 3 -> [[0, 1, 2], [3, 4]]
// 1 -> []