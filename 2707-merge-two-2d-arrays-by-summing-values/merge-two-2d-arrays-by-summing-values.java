class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
       Map<Integer, Integer> map = new HashMap<>();
       int maxId = 0;

       for (int[] arr : nums1) {
        map.merge(arr[0], arr[1], Integer::sum);
        maxId = Math.max(arr[0], maxId);
       }

       for (int[] arr : nums2) {
        map.merge(arr[0], arr[1], Integer::sum);
        maxId = Math.max(arr[0], maxId);
       }

        var result = new ArrayList<int[]>();

        for (int idx = 0; idx < maxId; ++idx) {
            if (map.containsKey(idx + 1))
                result.add(new int[]{idx + 1, map.get(idx + 1)});
        }

        int[][] arr = new int[result.size()][2];

        for (int idx = 0; idx < result.size(); ++idx) {
            arr[idx] = result.get(idx);
        }

        return arr;
    }
}