import sys

input = sys.stdin.readline

N = int(input())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()
B.sort(key=lambda x: -x)

answer = sum(A[i]*B[i] for i in range(N))

print(answer)