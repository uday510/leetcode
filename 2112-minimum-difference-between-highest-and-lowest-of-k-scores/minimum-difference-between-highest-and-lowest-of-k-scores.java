class Solution {
    public int minimumDifference(int[] arr, int w) {
        
        Arrays.sort(arr);
        int dif = (int) 1e9;

        for (int i = 0; i + w - 1 < arr.length; i++) {
            dif = Math.min(dif, arr[i + w - 1] - arr[i]);
        }

        return dif;
    }
}
