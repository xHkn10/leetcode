class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        return my_pow(x, n)


def my_pow(x, n) -> float:
    if n == 1:
        return x
    if n == -1:
        return 1 / x
    sub = my_pow(x, n // 2)
    if n % 2 == 0:
        return sub * sub
    else:
        return sub * sub * x
