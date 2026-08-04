class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        int mn = 101, mx = -mn;
        Set<Integer> seen = new HashSet<>();

        for (int a : arr) {
            mn = Math.min(mn, a);
            mx = Math.max(mx, a);
            seen.add(a);
        }

        List<Integer> res = new ArrayList<>();
        while (mn <= mx) {
            if (!seen.contains(mn))
                res.add(mn);

            mn++;
        }

        return res;
    }
}