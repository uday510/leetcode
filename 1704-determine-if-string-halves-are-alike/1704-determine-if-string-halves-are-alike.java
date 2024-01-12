class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int cnt = 0;
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('a', 'e','i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        for (int i = 0; i < n/2; ++i) {
            if (set.contains(s.charAt(i))) {
                 cnt++;
            }
            if (set.contains(s.charAt(i+n/2))) cnt--;
            
        }
        return cnt == 0;
    }
}
