class Solution {

    public int[] pivotArray(int[] arr, int p) {
        
        int n = arr.length;
        int[] res = new int[n];

        List<Integer> l = new ArrayList<>();
        List<Integer> e = new ArrayList<>();
        List<Integer> g = new ArrayList<>();

        for (int a : arr) {
            if (a < p) l.add(a);
            else if (a == p) e.add(a);
            else g.add(a);
        }

        int idx = 0;
        for (int a : l) {
            arr[idx++] = a;
        }

        for (int a : e) {
            arr[idx++] = a;
        }

        for (int a : g) {
            arr[idx++] = a;
        }

        return arr;
    }

}