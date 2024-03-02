import math
import sys



def isPrime(m):
    if m == 0 or m == 1:
        return False
    for i in range(2, int(math.sqrt(m))+1):
        if m % i == 0:
            return False
    return True
input = sys.stdin.readline
N = int(input())
answer = []
for _ in range(N):
    m = int(input())
    check = True
    while check:
        if isPrime(m):
            check = False
            answer.append(m)
        m += 1

for number in answer:
    print(number)