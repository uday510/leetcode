#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.length();
        unordered_map<char, int> cnt;
        int longest = 0;

        for (int i = 0, j = 0; j < n; j++) {

            cnt[s[j]]++;

            while (cnt[s[j]] > 1) {

                cnt[s[i]]--;

                i++;

            }

            longest = max(longest, j - i + 1);

        }

        return longest;

    }

};

/**


ans = 3

// store the counts of each character
map: [
a: 0
b: 1
c : 0
]

                            st
a   b   c   a   b   c   b   b
0   1   2   3   4   5   6   7
                            en

// loop through every element 
for (en -> 0 to n)
    
    // increment count of s[en]

    // used for removing duplicates elements (invalid elements in window)
    while (st <= en && map(s[en]) > 1) {
        decres s[st]--
        st++
    }


    ans = max(ans, en - st + 1);
             (0, 1)
        = 1
         = (1, 2) = 2
          = (2, 2 - 0 + 1) = 3

        = (3, 3 - 1 + 1) = 3
        = (3, 4 - 2 + 1) = 3
        (3, 6 - 5 + 1) = (3, 2) = 3



a
ab
abc -- 3
abca
abcab
abcabc
abcabcb
abcabcbb

b
---
b
bc --
bca -- 3
bcab
bcabc
bcabcb
bcabcbb

c
---
c --
ca
cab --- 3
cabc
cabcb
cabcbb

**/