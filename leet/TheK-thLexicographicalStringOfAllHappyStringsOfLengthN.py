flag = True
ns = []
letters = ["a", "b", "c"]


class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        global ns, flag
        if flag:
            for i in range(10):
                sub = []
                recurse(i + 1, sub, "")
                ns.append(sub.copy())
            flag = False
        if k > len(ns[n - 1]):
            return ""
        return ns[n - 1][k - 1]


def recurse(n, sub, curr: str):
    global ns
    if len(curr) == n:
        sub.append(curr)
        return
    if len(sub) == 100:
        return
    for letter in letters:
        if len(curr) == 0 or curr[len(curr) - 1] != letter:
            curr += letter
            recurse(n, sub, curr)
            curr = curr[:-1]


print(Solution().getHappyString(1, 3))
print(Solution().getHappyString(10, 100))
for n in ns:
    print(len(n))
