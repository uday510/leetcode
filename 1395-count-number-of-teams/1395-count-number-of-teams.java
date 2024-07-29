class Solution {
    public int numTeams(int[] rating) {
        int teams = 0;
        int n = rating.length;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {

                if (rating[j] > rating[i]) {
                    for (int k = j; k < n; ++k) {
                        if (rating[k] > rating[j]) {
                            teams++;
                        }
                    }
                }

                if (rating[j] < rating[i]) {
                    for (int k = j; k < n; ++k) {
                        if (rating[k] < rating[j]) {
                            teams++;
                        }
                    }
                }
            }
        }
        return teams;
    }
}