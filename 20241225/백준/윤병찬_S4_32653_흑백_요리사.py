import math

N = int(input())
steaks = tuple(map(int, input().split()))
answer = 1
for i in range(N):
    answer = math.lcm(answer, steaks[i])

print(answer * 2)
