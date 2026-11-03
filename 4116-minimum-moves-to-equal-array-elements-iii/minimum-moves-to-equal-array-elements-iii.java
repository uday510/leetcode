class Solution {
    public int minMoves(int[] arr) {
        int mx = arr[0];
        for (int a : arr) 
            mx = Math.max(mx, a);
        
        int cnt = 0;

        for (int a : arr) 
            cnt += mx - a;
        
        return cnt;
    }
}