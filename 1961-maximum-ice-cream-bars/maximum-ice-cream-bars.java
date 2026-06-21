class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] cnt = new int[100001];
        long total = 0;
        int n = costs.length, max = 0;

        for (int c : costs) {
            cnt[c]++;
            total += c;
            if (c > max) max = c;
        }

        if (total < coins) return n;

        long cur = coins;
        int i = 0, res = 0;
        while (i <= max && cur > 0) {
            long req = i * cnt[i];

            if (cur - req < 0) {
                res += (int) (cur / i);
                return res;
            }

            cur -= req;
            res += cnt[i];

            i++;
        }

        return res;
    }
}