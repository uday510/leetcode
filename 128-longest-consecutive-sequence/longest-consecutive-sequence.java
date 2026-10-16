class Solution {
    public int longestConsecutive(int[] arr) {
        Set<Integer> vals = new HashSet<>();
        int longest = 0;

        for (int a : arr) vals.add(a);

        for (int a : vals) {
            if (vals.contains(a - 1)) continue;

            int cur = 1;
            while (vals.contains(a + 1)) {
                a++; cur++;
            }

            longest = Math.max(longest, cur);
        }

        return longest;
    }
}