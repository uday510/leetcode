class Solution {
    public int maximumLength(int[] arr) {
        
        Map<Long, Integer> cnts = new HashMap<>();

        for (int a : arr) 
            cnts.merge((long) a, 1, Integer::sum);

        int res = 0;
        Integer ones = cnts.get(1L);
        if (ones != null) res = ( (ones & 1) == 1 ? ones : ones - 1);

        for (long x : cnts.keySet()) {
            if (x == 1) continue;

            int len = 0;
            long cur = x;
            while (cnts.getOrDefault(cur, 0) >= 2) {
                len += 2;
                cur *= cur;
            }

            len += cnts.containsKey(cur) ? 1 : -1;
            res = Math.max(res, len);
        }

        return res;
    }
}


// 1 1 1 1 5