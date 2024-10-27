class Solution {
    public int removeElement(int[] nums, int val) {
       int k = 0;

       for (int num : nums)
        if (num != val) 
            nums[k++] = num;

        System.out.println(k);
        return k; 
    }
}