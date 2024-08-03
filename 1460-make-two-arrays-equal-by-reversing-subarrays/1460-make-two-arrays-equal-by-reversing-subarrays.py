class Solution:
    def canBeEqual(self, A: List[int], B: List[int]) -> bool:
        return sorted(A) == sorted(B)
        