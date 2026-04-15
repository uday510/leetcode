class Solution {

    public int closestTarget(String[] arr, String t, int st) {

        int n = arr.length;
        int mn = n;

       for (int idx = 0; idx < n; idx++) {

           int idx1 = (st + idx) % n;
           int idx2 = (st - idx + n) % n;

            if (arr[idx1].equals(t) || arr[idx2].equals(t)) {
                mn = Math.min(mn, idx);
            }
           
       }

        return mn == n ? -1 : mn;
    }

}
