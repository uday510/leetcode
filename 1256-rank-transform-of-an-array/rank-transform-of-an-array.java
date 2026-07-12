class Solution {
    public int[] arrayRankTransform(int[] or) {
        int n = or.length;
        int[] arr = or.clone();

        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();

        int idx = 1;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], idx++);
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(or[i]);
        }

        System.out.println(Arrays.toString(or));
        System.out.println(Arrays.toString(arr));
        System.out.println(map);

        return res;
    }
}