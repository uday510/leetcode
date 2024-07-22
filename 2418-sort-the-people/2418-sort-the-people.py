class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        A = sorted(zip(names, heights), key = lambda x: -x[1])
        return [a for a,b in A]