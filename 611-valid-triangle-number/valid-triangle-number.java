class Solution {
    public int triangleNumber(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int res = 0;
        
        for (int k = 0; k < n; k++) {
            int i = 0, j = k - 1;

            while (i < j) {

                if (arr[i] + arr[j] > arr[k]) {
                    res += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }

        return res;
    }
}

/**

2  2  2  4  5


 */