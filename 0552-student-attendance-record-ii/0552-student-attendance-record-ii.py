class Solution:
    def checkRecord(self, n: int) -> int:
        
        @lru_cache(100)
        def fn(i, absent, late): 
            """Return number of attendance eligible for award."""
            if i == n: return 1
            ans = fn(i+1, absent, 0) # present 
            if absent == 0: ans += fn(i+1, 1, 0) # absent 
            if late < 2: ans += fn(i+1, absent, late+1) # late 
            return ans % 1_000_000_007
        
        return fn(0, 0, 0)