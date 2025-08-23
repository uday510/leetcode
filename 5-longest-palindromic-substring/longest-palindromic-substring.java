class Solution {
    public String longestPalindrome(String str) {
        
        int[] max = {0, 1};

        for (int i = 0; i < str.length(); ++i) {
            
            int[] s1 = find(i - 1, i, str);
            int[] s2 = find(i - 1, i + 1, str);

            int[] s = {0, 0};

            s = s2[1] - s2[0] > s1[1] - s1[0] ? s2 : s1; 

            max = s[1] - s[0] > max[1] - max[0] ? s : max;
        }

        return str.substring(max[0], max[1]);
    }

    private int[] find(int i, int j, String s) {

        while (i > -1 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) break;
            i--; j++;
        }
        
        return new int[] {i + 1, j};
    }
}