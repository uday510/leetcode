class Solution {
    public boolean asteroidsDestroyed(int mass, int[] ast) {
       Arrays.sort(ast);

       long cur = mass;

       List<Integer> rem = new ArrayList<>(); 
       for(int a : ast) {
            if (cur < a) rem.add(a);
            else cur += a;
       }
       
       for (int a : rem) {
            if (a > cur) return false;
            cur += a;
       } 


       return true;
    }
}