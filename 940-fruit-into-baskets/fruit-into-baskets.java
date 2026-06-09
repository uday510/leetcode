class Solution {
    public int totalFruit(int[] arr) {
        
        int[] cnt = new int[100000];
        int mx = 0, k = 2, unique = 0;

        for (int i = 0, j = 0; j < arr.length; j++) {
            if (cnt[arr[j]]++ == 0) unique++;

            while (unique > k) {
                if (--cnt[arr[i]] == 0) unique--;
                i++;
            }

            mx = Math.max(mx, j - i + 1);
        }

        return mx;
    }
}