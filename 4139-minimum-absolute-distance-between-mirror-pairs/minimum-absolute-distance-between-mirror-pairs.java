class Solution {
    public int minMirrorPairDistance(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();

        int res = arr.length;
        for (int idx = 0; idx < arr.length;) {

            int cur = arr[idx];
            int rev = reverse(cur);

            Integer val = map.get(cur);

            if (val != null) {
                res = Math.min(res, idx - val);
            }

            map.put(rev, idx++);
        }

        return res == arr.length ? -1 : res;
    }

    private int reverse(int num) {

        int reversed = 0;
        int cur = num;

        while (cur > 0) {
            reversed = (reversed * 10) + (cur % 10);
            cur /= 10;
        }

        return reversed;
    }
}