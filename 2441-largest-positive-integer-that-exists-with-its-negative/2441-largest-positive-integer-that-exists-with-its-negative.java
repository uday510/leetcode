class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int maxK = -1;
        for (int num : nums) {
            if (!set.contains(num) && (set.contains(Math.abs(num)) || set.contains(num * -1))) {
                maxK = Math.max(maxK, Math.abs(num));
            }
            set.add(num);
        }

        return maxK;
    }
}