class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int idx1 = 0;
        int idx2 = 0;
        int N = nums1.length;
        int M = nums2.length;
        
       List<Integer> list = new ArrayList<>();
       while (idx1 < N && idx2 < M) {
           if (nums1[idx1] < nums2[idx2]) {
               ++idx1;
           } else if (nums2[idx2] < nums1[idx1]) {
               ++idx2;
           } else {
               list.add(nums1[idx1]);
               ++idx1;
               ++idx2;
           }
       }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}