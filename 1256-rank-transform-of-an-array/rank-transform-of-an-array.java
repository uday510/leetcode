class Solution {
    public int[] arrayRankTransform(int[] or) {
        int n = or.length;
        int[] arr = or.clone();

        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : arr) {
            map.putIfAbsent(x, map.size() + 1);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(or[i]);
        }

        return res;
    }
}