class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] cnt = new int[1001];
        
        for (int num : nums1)
            ++cnt[num];
        
        
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (cnt[num] > 0) {
                list.add(num);
                --cnt[num];
            }
        }
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}