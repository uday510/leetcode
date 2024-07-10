class Solution {
    public int minOperations(String[] logs) {
        int ops = 0;
        
        for (String log : logs) {

            if (log.equals("./")) {
                continue;
            }
            if (!log.equals("../")) {
                ops++;
            } else {
                ops--;
            }
            ops = Math.max(0, ops);
        }
        
        return ops;
    }
}