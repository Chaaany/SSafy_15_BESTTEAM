import math

def calc(number):
    max_n = (-1 + math.sqrt(1 + 8 * number)) / 2
    return int(max_n)

T = int(input())
for i in range(T):
    N = int(input())
    print(calc(N))