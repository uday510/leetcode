class Solution {
    public int findKthPositive(int[] arr, int k) {
    	int n = arr.length;
        int l = 0, r = n;    

        while (l < r) {
        	int m = (l + r) >> 1;

        	if (arr[m] - m - 1 < k) l = m + 1;
        	else r = m;
        }

        return l + k;
    }
}

/**

[1 2 3 4 5 6 7 8 9 10 11] 

missing [1 5 6 8 9 10 ...] 

2 3 4 7 11

 */