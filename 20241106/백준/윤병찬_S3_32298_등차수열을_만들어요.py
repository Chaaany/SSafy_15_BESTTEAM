# A + i * M이 소수면 안됨
N, M = map(int, input().split())

answer = []
for i in range(N):
    answer.append(2 * M + i * M)

print(" ".join(map(str, answer)))