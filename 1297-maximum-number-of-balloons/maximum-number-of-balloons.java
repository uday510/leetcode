class Solution {
    private static final String s = "balloon";
    private static final Set<Character> d = new HashSet<>();
    static {
        d.add('l');
        d.add('o');
    }

    public int maxNumberOfBalloons(String t) {
        
        int[] cnt = new int[26];

        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i) - 'a']++;
        }
    
        int mn = t.length();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            int cur = cnt[idx];

            if (cnt[idx] == 0) return 0;

            
            if(d.contains(c)) {
                cur /= 2;
            }

            mn = Math.min(mn, cur);
        }

        return mn;
    }
}