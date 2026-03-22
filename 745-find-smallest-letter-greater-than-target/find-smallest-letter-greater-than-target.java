class Solution {
    public char nextGreatestLetter(char[] arr, char target) {
        
        int l = 0, r = arr.length;

        while (l < r) {
            int m = (l + r) >> 1;

            if (arr[m] <= target) l = m + 1;
            else r = m;
        }

        return l < arr.length ? arr[l] : arr[0];
    }
}