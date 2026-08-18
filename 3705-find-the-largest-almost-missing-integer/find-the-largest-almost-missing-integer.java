class Solution {
    public int largestInteger(int[] arr, int k) {

        int n = arr.length, mx = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n - k + 1; i++) {
            for (int j = i; j < n && j < (i + k); j++) {
                map.merge(arr[j], 1, Integer::sum);
            }
        }

        if (k == n)
            return map.keySet().stream().max(Comparator.naturalOrder()).orElse(null);

        for (Map.Entry<Integer, Integer> ks : map.entrySet()) {
            if (ks.getValue() == 1) 
                mx = Math.max(mx, ks.getKey());
        }

        return mx;   
    }
}