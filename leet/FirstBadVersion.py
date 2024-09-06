class Solution:
    def firstBadVersion(self, n: int) -> int:
        low = 1
        high = n
        mid = (low + high) // 2

        while True:
            is_bad = isBadVersion(mid)
            if is_bad and not isBadVersion(mid - 1):
                return mid
            if not is_bad and isBadVersion(mid + 1):
                return mid + 1

            if is_bad:
                high = mid - 1
            else:
                low = mid + 1
            mid = (low + high) // 2


def isBadVersion(version: int) -> bool:
    return version >= 1


print(Solution().firstBadVersion(3))
