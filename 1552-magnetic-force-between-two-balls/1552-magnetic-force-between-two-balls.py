class Solution:
    def maxDistance(self, A: List[int], m: int) -> int:
        A.sort()
        
        def can_place(force):
            balls = 1
            at = A[0]
            
            for pos in A:
                if pos - at >= force:
                    at = pos
                    balls += 1
            
            return balls >= m
            
        
        left = 1
        right = 10**10
        
        while left < right:
            mid = left + right + 1 >> 1
            
            if can_place(mid):
                left = mid
            else:
                right = mid - 1
        
        return left