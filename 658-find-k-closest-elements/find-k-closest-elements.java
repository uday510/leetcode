class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        int l = 0, r = n;
        
        while (l < r) {
            
            int m = l + ((r - l) >> 1);
            
            if (arr[m] < x) l = m + 1;
            else r = m;
        }
        
        
        r = l;
        
        while (r - l - 1 < k) {
            if (l == -1) {
                r++;
            } else if (r == n || Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l--;
            } else {
                r++;
            }
        }
        
        
        List<Integer> res = new ArrayList<>();
        
        for (int idx = l + 1; idx < r; idx++) {
            res.add(arr[idx]);
        }
        
        return res;

    }
}