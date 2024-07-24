class Solution:
    def sortJumbled(self, mapping: List[int], nums: List[int]) -> List[int]:
        def func(val):
            num = 0

            for digit in map(int, list(str(val))):
                digit = mapping[digit]
                num = num*10 + digit

            return num
        
        nums.sort(key = func)
        return nums