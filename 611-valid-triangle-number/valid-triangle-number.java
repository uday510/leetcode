class Solution {
    public int triangleNumber(int[] arr) {
        int n = arr.length;
        int total = 0;

        Arrays.sort(arr);


        for (int k = 0; k < n; k++) {

            int i = 0, j = k - 1;

            while (i < j) {

                if (arr[i] + arr[j] > arr[k]) {
                    total += (j - i);
                    j--;
                } else {
                    i++;
                }
            }

        }

        return total;

    }
}