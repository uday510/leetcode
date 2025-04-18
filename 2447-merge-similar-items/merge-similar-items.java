class Solution {

    int min;
    int max;
    Map<Integer, Integer> map;

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        map = new HashMap<>();

        addToMap(items1);
        addToMap(items2);

        List<List<Integer>> list = new ArrayList<>();

        if (map.isEmpty()) return list;

        for (int i = min; i <= max; ++i) {
            if (!map.containsKey(i)) continue;
            list.add(new ArrayList<>(Arrays.asList(i, map.get(i))));
        }

        return list;
    }

    private void addToMap(int[][] items) {

        for (int[] item : items) {
            int value = item[0];
            int weight = item[1];
            min = Math.min(min, value);
            max = Math.max(max, value);

            map.merge(value, weight, Integer::sum);
        }
    }
}