# 2 2 3 4 9 10
# 무조건 가운데에 있는 두 수가 최소임
def check(N):
    global natural_numbers
    standard = natural_numbers[N]
    return sum([abs(num - standard) for num in natural_numbers])

import sys
input = sys.stdin.readline

N = int(input())
natural_numbers = list(map(int, input().split()))
natural_numbers.sort()

if N % 2 == 0:
    check1 = check(N // 2 - 1)
    check2 = check(N // 2)
    answer = natural_numbers[N // 2 - 1] if check1 <= check2 else natural_numbers[N // 2]
    print(answer)
else:
    print(natural_numbers[N // 2])