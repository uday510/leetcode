class Solution {
    public int maxProfit(int[] prices, int f) {
        int obsp = -prices[0], ossp = 0;


        for (int p : prices) {
            int nbsp = 0, nssp = 0;

            if (ossp - p > obsp) 
                nbsp = ossp - p;
            else
                nbsp = obsp;
            
            if (obsp + p - f > ossp)
                nssp = obsp + p - f;
            else 
                nssp = ossp;
            
            obsp = nbsp;
            ossp = nssp;
        }

        return ossp;

    }
}