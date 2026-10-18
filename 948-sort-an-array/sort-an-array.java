class Solution {
    public int[] sortArray(int[] arr) {
        mergesort(0, arr.length - 1, arr);
        return arr;
    }
    private void mergesort(int l, int r, int[] arr) {
        if (l >= r) return;

        int m = l + ((r - l) >> 1);

        mergesort(l, m, arr);
        mergesort(m + 1, r, arr);
        merge(l, m, m + 1, r, arr);
    }

    private void merge(int l1, int l2, int r1, int r2, int[] arr) {
        int[] l = new int[l2 - l1 + 1];
        int[] r = new int[r2 - r1 + 1];

        for (int i = 0; i < l.length; i++) 
            l[i] = arr[l1 + i];
        
        for (int i = 0; i < r.length; i++) 
            r[i] = arr[r1 + i];
        

        int i = 0, j = 0, k = l1;

        while (i < l.length && j < r.length) {
            if (l[i] < r[j]) {
                arr[k] = l[i++];
            } else {
                arr[k] = r[j++];
            }
            k++;
        }

        while (i < l.length) arr[k++] = l[i++];
        while (j < r.length) arr[k++] = r[j++];
    }
}