#
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
R = int(input())

farms = [[False for _ in range(R + 1)] for _ in range(R + 1)]
second = 0
while not farms[n][m]:
    farms[n][m] = True
    if n + 1 + m + 1 < R:
        n+=1
        m+=1
        second+=1
    else:
        n //= 2
        m //= 2
        second+=1

print(second)