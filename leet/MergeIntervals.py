from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:

        intervals.sort()

        ans = list()

        i = 0
        window = 0
        dominant = intervals[0][1]

        while i != len(intervals) - 1:
            if dominant >= intervals[i + 1][0]:
                dominant = max(dominant, intervals[i + 1][1])
                window += 1
            else:
                ans.append([intervals[i - window][0], dominant])
                dominant = intervals[i + 1][1]
                window = 0
            i += 1

        ans.append([intervals[i - window][0], dominant])

        return ans


print(Solution().merge([[1, 3], [2, 6], [8, 10], [15, 18]]))
print(Solution().merge([[1, 4], [2, 3]]))
print(Solution().merge([[2, 3], [4, 5], [6, 7], [8, 9], [1, 10]]))
