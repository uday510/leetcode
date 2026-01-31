class Solution {
    public char nextGreatestLetter(char[] arr, char t) {
        
        int l = 0, r = arr.length;

        while (l < r) {
            int m = (l + r) >> 1;

            if (arr[m] <= t) l = m + 1;
            else r = m;
        }

        return (l == arr.length ? arr[0] : arr[l]);
    }
}