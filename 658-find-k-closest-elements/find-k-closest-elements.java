class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n = arr.length;
        int l = 0, r = n;
        
        while (l < r) {
            
            int m = l + ( (r - l) >> 1);
            
            if (arr[m] < x) l = m + 1;
            else r = m;
        }
        
        int left = l;
        int right = l;
        
        while (right - left - 1 < k) {
            
            if (left == -1) {
                right++;
            } else if (right == n) {
                left--;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left--;
            } else {
                right++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        for (int idx = left + 1; idx < right; idx++) {
            res.add(arr[idx]);
        }
        
        return res;
        
    }

}

/**




l = 2 => 3

 0  1  2  3  4     
[1, 2, 3, 4, 5]

left = 0 => 
right = 3 =>



 */