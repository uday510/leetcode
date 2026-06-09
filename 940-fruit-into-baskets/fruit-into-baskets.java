class Solution {
    public int totalFruit(int[] arr) {
        
        Map<Integer, Integer> cnt = new HashMap<>();
        int mx = 0, k = 2;

        for (int i = 0, j = 0; j < arr.length; j++) {
            cnt.put(arr[j], cnt.getOrDefault(arr[j], 0) + 1);

            while (cnt.size() > k) {
                cnt.put(arr[i], cnt.get(arr[i]) - 1);

                if (cnt.get(arr[i]) == 0) {
                    cnt.remove(arr[i]);
                }

                i++;
            }

            mx = Math.max(mx, j - i + 1);
        }

        return mx;
    }
}