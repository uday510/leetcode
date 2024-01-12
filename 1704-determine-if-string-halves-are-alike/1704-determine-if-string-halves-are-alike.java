class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int cnt1 = 0;
        int cnt2 = 0;
        Set<Character> set = new HashSet<>();
        // set.addAll('a', 'e','i', 'o', 'u', 'A', 'E', 'I');
        set.add('a');  
        set.add('e');  
        set.add('i'); 
        set.add('E');  
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('I');
        set.add('O');
        set.add('U');
        System.out.println(set);
        
        for (int i = 0; i < n/2; ++i) {
            if (set.contains(s.charAt(i))) cnt1++;
            if (set.contains(s.charAt(i+n/2))) cnt2++;
        }
        return cnt1 == cnt2;
    }
}