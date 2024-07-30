class Solution {
    public int minimumDeletions(String s) {
        
        int n = s.length();
        
        // int[] pf = new int[n];
        // int[] sf = new int[n];
        
        
        // for (int i = 1; i < n; ++i) {
        //      pf[i] = pf[i-1];
        //     if (s.charAt(i) == 'b') {
        //         pf[i] += 1;
        //     }
        // }
        
        // for (int i = n-2; i > -1; --i) {
        //     sf[i] = sf[i+1]; 
        //     if (s.charAt(i) == 'a') {
        //         sf[i] += 1;
        //     }
        // }

        int cnt = 0;
        Stack<Character> st = new Stack<>();

        for (int i = n-1; i > -1; --i) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && st.peek() == 'a' && ch == 'b') {
                st.pop();
                ++cnt;
            } else {
                st.push(ch);
            }
            
        }
        return cnt;
    }
}


// i = 0

//         b -> 0, a -> 3
        
// i = 1
//         b -> 0, a -> 2

// i = 2
//         b -> 0, a -> 2
        
// i = 3
//         b -> 1, a -> 1
        
// i = 4
//         b -> 1, a -> 1

// i = 5
//         b -> 2, a -> 1
    
// i = 6 
//         b -> 3, a -> 0
        
// i = 7 
//         b -> 3, a -> 0

