import math
from typing import List


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        missing_num = 2 ** (len(nums) + 1) - 1
        for x in nums:
            missing_num -= 2 ** x
        return int(math.log2(missing_num))


print(Solution().missingNumber([1, 2]))
print(Solution().missingNumber([9,6,4,2,3,5,7,0,1]))
