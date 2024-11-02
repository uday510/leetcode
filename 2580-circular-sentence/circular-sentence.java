class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        int N = s.length;
        int len = N%2 == 0 ? N : N+1;
        
        char en = s[0].charAt(s[0].length()-1);
        for (int i = 1; i < len; ++i) {
            int idx = (i % N);
            char st = s[idx].charAt(0);

            if (st != en) {
                System.out.println(st + " " + en);
                return false;
            }

            en = s[idx].charAt(s[idx].length()-1);
        }

        return s[0].charAt(0) == s[N-1].charAt(s[N-1].length()-1);
    }
}