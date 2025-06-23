class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int index = bisectLeft(lis, num);
            if (index == lis.size()) lis.add(num);
            else lis.set(index, num);
        }

        return lis.size();
    }

    private int bisectLeft (List<Integer> list, int target) {
        int leftIdx = 0, rightIdx = list.size();

        while (leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) >> 1;
            if (list.get(midIdx) < target) leftIdx = midIdx + 1;
            else rightIdx = midIdx;
        }

        return leftIdx;
    }
}