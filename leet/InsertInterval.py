import bisect
from typing import List


class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        if len(intervals) == 0:
            return [newInterval]

        idx = bisect.bisect_left(intervals, newInterval) - 1
        i = 0 if idx == -1 else idx

        started = False
        start = 0

        while i < len(intervals):
            if overlaps(intervals[i], newInterval):
                if not started:
                    started = True
                    start = i
            else:
                if started:
                    to_be_inserted = [min(intervals[start][0], newInterval[0]),
                                      max(intervals[i - 1][1], newInterval[1])]
                    intervals[start:i] = [to_be_inserted]
                    return intervals
                if idx + 1 == i:
                    intervals.insert(i, newInterval)
                    return intervals

            i += 1

        if not started:
            intervals.append(newInterval)
            return intervals

        to_be_inserted = [min(intervals[start][0], newInterval[0]), max(intervals[i - 1][1], newInterval[1])]
        intervals[start:i] = [to_be_inserted]
        return intervals


def overlaps(list1, list2) -> bool:
    if list1[0] <= list2[0]:
        if list1[1] >= list2[0]:
            return True
        return False
    if list2[1] >= list1[0]:
        return True
    return False


print(Solution().insert(intervals=[[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], newInterval=[4, 8]))
print(Solution().insert(intervals=[[1, 3], [6, 9]], newInterval=[2, 5]))
print(Solution().insert(intervals=[], newInterval=[2, 5]))
print(Solution().insert(intervals=[[1, 5]], newInterval=[2, 3]))
print(Solution().insert(intervals=[[1, 5]], newInterval=[5, 7]))
print(Solution().insert(intervals=[[1, 5]], newInterval=[6, 8]))
print(Solution().insert(intervals=[[1, 5]], newInterval=[0, 3]))
print(Solution().insert(intervals=[[2, 3], [5, 7]], newInterval=[0, 6]))
