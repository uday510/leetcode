class Solution {
    public long countMajoritySubarrays(int[] arr, int t) {
        
        Map<Integer, Integer> cnts = new HashMap<>();
        long cnt = 0, sum = 0;
        int p = 0;

        cnts.put(0, 1);
        for (int a : arr) {
            if (a == t) {
                sum += cnts.getOrDefault(p, 0);
                p++;
            } else {
                sum -= cnts.getOrDefault(--p, 0);
            }

            cnts.merge(p, 1, Integer::sum);
            cnt += sum;
        }

        return cnt;
    }
}