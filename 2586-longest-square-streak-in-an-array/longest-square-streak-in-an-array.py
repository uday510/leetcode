class Solution:
    def longestSquareStreak(self, A: List[int]) -> int:
        seen = set(A)
        ans = 0

        for val in A:
            sqrt = val**0.5
            if sqrt in seen:
                continue
            
            start = val
            count = 0

            while start in seen:
                count += 1
                start = start**2
            
            ans = max(ans, count)
        
        if ans < 2:
            return -1
        
        return ans