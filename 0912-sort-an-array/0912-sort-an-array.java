class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    public void mergeSort(int[] nums, int low, int high) {
        if (high <= low)
            return;
        
        int mid = (high + low) >> 1;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        merge(nums, low, mid, mid+1, high);
    }
    public void merge(int[] nums, int lStart, int lEnd, int rStart, int rEnd) {
       int len1 = lEnd-lStart+1;
       int len2 = rEnd-rStart+1;
       int[] tmp1 = new int[len1];
       int[] tmp2 = new int[len2];
      
      int i = 0;
      int j = 0;
      for (; i < len1; ++i)
          tmp1[i] = nums[i+lStart];
      
      for (; j < len2; ++j)
          tmp2[j] = nums[j+rStart];
        
     i=0;
     j=0;
     int k = lStart;
        
     while (i < len1 && j < len2)
         if (tmp1[i] <= tmp2[j])
             nums[k++] = tmp1[i++];
         else 
             nums[k++] = tmp2[j++];
        
    
    while (i < len1)
        nums[k++] = tmp1[i++];
        
    while (j < len2)
        nums[k++] = tmp2[j++];
    }
}