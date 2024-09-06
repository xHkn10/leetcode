from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = list()
        recurse(ans, nums, list(), 0)
        return ans


def recurse(ans, nums, curr, idx):
    if idx == len(nums):
        ans.append(curr.copy())
        return

    recurse(ans, nums, curr, idx + 1)
    curr.append(nums[idx])
    recurse(ans, nums, curr, idx + 1)
    curr.pop()


print(Solution().subsets([1, 2, 3]))
