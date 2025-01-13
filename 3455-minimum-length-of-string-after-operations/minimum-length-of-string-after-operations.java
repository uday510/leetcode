class Solution {
    public int minimumLength(String s) {
        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int result = 0;

        for (int idx = 0; idx < 26; ++idx) {
            int curr = cnt[idx];

            if (curr == 0) continue;
            
                if (curr % 2 == 0) {
                    result += 2;
                } else {
                    result += 1;
                }

            System.out.println(curr + " : " + result);
        }

        return result;
    }
}

/**

a --> 3 -> 1

b --> 4 -> 2
c --> 2 -> 2

 */