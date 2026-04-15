class Solution {

    public int closestTarget(String[] arr, String t, int st) {

        int n = arr.length;

       for (int idx = 0; idx < n; idx++) {

           int l = (st + idx) % n;
           int r = (st - idx + n) % n;

            if (arr[l].equals(t) || arr[r].equals(t)) {
                return idx;
            }
           
       }

        return -1;
    }

}
