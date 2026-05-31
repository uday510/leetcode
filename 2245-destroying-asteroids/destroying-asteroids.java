class Solution {
    public boolean asteroidsDestroyed(int mass, int[] ast) {
       Arrays.sort(ast);

       long cur = mass;

       for(int a : ast) {
            if (cur < a) return false;
            else cur += a;
       }

       return true;
    }
}