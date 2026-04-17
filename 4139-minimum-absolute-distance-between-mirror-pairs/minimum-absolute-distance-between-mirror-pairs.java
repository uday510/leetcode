class Solution {
    public int minMirrorPairDistance(int[] arr) {
        
        Map<Integer, Integer> cnts = new HashMap<>();

        int res = arr.length;
        for (int idx = 0; idx < arr.length; idx++) {

            int cur = arr[idx];
            int rev = reverse(cur);

            Integer val = cnts.get(cur);

            if (val != null) {
                res = Math.min(res, idx - val);
            }

            cnts.put(rev, idx);
        }

        return res == arr.length ? -1 : res;
    }

    private int reverse(int num) {

        int reversed = 0;
        int cur = num;

        while (cur > 0) {
            reversed = reversed * 10 + (cur % 10);
            cur /= 10;
        }

        return reversed;
    }
}