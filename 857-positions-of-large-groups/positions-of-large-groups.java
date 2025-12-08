class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        int n = s.length();
        
        for (int i = 0; i < n;) {
            
            int j = i;
            
            while(j < n && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            
            int len = j - i + 1;
            
            if (j - i >= 3) {
                System.out.println(s.substring(i, j));
                list.add(new ArrayList<>(List.of(i, j - 1)));
            }
            i = j;
        }
        
        return list;
    }
}