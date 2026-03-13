class Solution {
    public int[] twoSum(int[] A , int T) {

     int cur;
     for (int i = 0, j = A.length - 1; i < A.length; ) {
        cur = A[i] + A[j];

        if (cur == T) {
            return new int[] {i + 1, j + 1};
        } else if (cur < T) {
            i++;
        } else {
            j--;
        }

     }

     return new int[] {-1, -1};

    }
}