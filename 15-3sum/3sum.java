class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            
            int j = i + 1, k = n - 1;

            while (j < k) {

                int cur = arr[i] + arr[j] + arr[k];

                if (cur < 0) j++;
                else if (cur > 0) k--;
                else {

                    res.add(List.of(arr[i], arr[j], arr[k]));

                    j++;
                    k--;

                    while (j < n && arr[j] == arr[j - 1]) j++;

                    while (k > -1 && arr[k] == arr[k + 1]) k--;
                }
            }
        }


        return res;


    }
}