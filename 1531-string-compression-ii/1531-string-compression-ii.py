import string

def compress(v):
    if v <= 2: return v
    if v < 10: return 2
    if v < 100: return 3
    return 4

class Solution:
    def getLengthOfOptimalCompression(self, s: str, k: int) -> int:
        @lru_cache(None)
        def dp(e, delcnt):
            if e < 0:
                return 0
            
            ans = 10000
            notsame = 0
            same = 0
            for i in range(e, -1, -1):
                if s[i] != s[e]:
                    notsame += 1
                else:
                    same += 1
                if notsame > delcnt:
                    break
                ans = min(ans, dp(i-1, delcnt - notsame) + compress(same))
            return ans                           
        
        return min([dp(len(s)-1-delcnt, k-delcnt) for delcnt in range(k+1)])
