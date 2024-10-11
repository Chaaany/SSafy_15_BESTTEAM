import math

N, R = map(int, input().split())

num = N - R
result = 0

for i in range(1, int(math.sqrt(num)) + 1):
    if num % i == 0:
        if i > R:
            result += i
        if num // i != i and num // i > R:
            result += num // i

print(result)
