class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zeroes = 0;
        int ones = 0;
        
        for (int student : students) {
            if (student == 1)
                ++ones;
            else 
                ++zeroes;   
        }
        
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (zeroes == 0)
                    return ones;
                --zeroes;
            } else {
                if (ones == 0)
                    return zeroes;
                --ones;
            }
        }   
        return 0;
    }
}

