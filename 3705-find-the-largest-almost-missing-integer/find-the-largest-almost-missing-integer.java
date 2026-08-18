class Solution {
    public int largestInteger(int[] arr, int k) {

        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n - k + 1; i++) {
            for (int j = i; j < n && j < (i + k); j++) {
                map.merge(arr[j], 1, Integer::sum);
            }
        }

        return k == n ? 
             map
            .keySet()
            .stream()
            .max(Comparator.naturalOrder()).orElse(-1)
            : map.entrySet().stream()
        .filter(e -> e.getValue() == 1)
        .map(Map.Entry::getKey)
        .max(Comparator.naturalOrder())
        .orElse(-1);

    }
}