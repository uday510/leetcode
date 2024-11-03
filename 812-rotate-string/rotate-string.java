class Solution {
    public boolean rotateString(String s, String goal) {
        int N = goal.length();
        int M = s.length();
        if (N != M) return false;
        List<Integer> starts = findStart(s, goal.charAt(0));
        
       for (int start : starts) {
        System.out.println("START" + "" + start);
            if (valid(start, N, s, goal))  
                return true;
       }

     return false;
    }

    private boolean valid(int start, int N, String s, String goal) {
        for (int i = 0; i < N; ++i) {
        int idx = (i + start + N) % N;
        char c1 = s.charAt(idx);
        char c2 = goal.charAt(i);

        if (c1 != c2) return false;
       }
       return true;
    }

    private List<Integer> findStart(String s, char c) {
        var starts = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == c) {
                starts.add(i);
            }
         }
         return starts;
    }
}