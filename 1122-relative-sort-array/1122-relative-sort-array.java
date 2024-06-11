class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        
        for (int num : arr1) 
            ++count[num];
        
        int index = 0;
        for (int idx = 0; idx < arr2.length; ++idx) {
            int currentNum = arr2[idx];
            
            while (count[currentNum]-- > 0) {
                arr1[index++] = currentNum;
            }
                
        }
        
        for (int i = 0; i < count.length; ++i) {
            while (count[i]-- > 0)
                arr1[index++] = i;
        }
        
        return arr1;
    }
}