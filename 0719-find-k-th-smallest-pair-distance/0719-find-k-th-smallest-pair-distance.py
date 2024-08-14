class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        nums.sort()

        left, right = 0, max(nums) - min(nums)

        def check_distance(mid: int) -> int:
            """
            Count the number of pairs with a distance less than or equal to mid.
            """
            count = 0
            for index, num in enumerate(nums):
                next_index = bisect.bisect_right(nums, num + mid)
                count += next_index - index - 1
            return count

        while left < right:
            mid = (left + right) >> 1
            if check_distance(mid) < k:
                left = mid + 1
            else:
                right = mid

        return left