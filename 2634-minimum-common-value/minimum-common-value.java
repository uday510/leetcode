class Solution {



    public int getCommon(int[] arr1, int[] arr2) {
        
        int n = arr1.length, m = arr2.length;
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) i++;
            else if (arr1[i] > arr2[j]) j++;
            else return arr1[i];
        }

        return -1;
    }

}