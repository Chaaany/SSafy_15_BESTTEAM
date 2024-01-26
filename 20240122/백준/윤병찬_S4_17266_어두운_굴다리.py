# 굴다리 길이 N
# 가로등 개수 M
# M개의 설치할 수 있는 가로등 위치 x
# 가로등 위치 x 오름차순, 가로등 위치 중복 X, 정수
# 시작점에 가로수가 있을 경우
# 마지막에 가로수가 있을 경우
# 시작점과 마지막에 가로수가 있을 경우
import math
import sys

input = sys.stdin.readline

N = int(input())
M = int(input())
locations = list(map(int, input().split()))

answer = locations[0]
for i in range(len(locations) - 1):
    answer = max(answer, math.ceil((locations[i + 1] - locations[i]) / 2))

answer = max(answer, locations[0] - 0)
answer = max(answer, N - locations[len(locations)-1])

print(answer)

