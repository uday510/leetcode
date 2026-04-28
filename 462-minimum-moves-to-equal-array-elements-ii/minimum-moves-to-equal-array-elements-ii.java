class Solution {
    public int minMoves2(int[] arr) {
        
        Arrays.sort(arr);

        int n = arr.length;
        int median = arr[n / 2];
        int mvs = 0;

        for (int cur : arr) {
            mvs += Math.abs(median - cur); 
        }

        return mvs;
    }
}   