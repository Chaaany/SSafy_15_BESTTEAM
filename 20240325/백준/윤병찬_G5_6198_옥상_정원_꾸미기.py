# 그대로 구현 시 O(N^2)이기 때문에 최적화가 필요함 O(N) ~ O(NlogN)
# 1. 브루트 포스
import sys

# N = int(sys.stdin.readline())

# buildings = [0] * N
# answers = [0] * N

# for i in range(N):
#     buildings[i] = int(sys.stdin.readline())


# for i in range(N):
# 	for j in range(i+1, N):
# 		if buildings[i] > buildings[j]:
# 			answers[i] += 1
# 		else:
# 			break

# print(sum(answers))

# 2. 최적화
# 리스트 두 개 1번 리스트는 빌딩 순서대로 높이 표기, 2번 리스트는 2차원 리스트로 빌딩 높이 + 벤치마킹 가능했던 빌딩 갯수 표기
# 1. 뒤에서부터 읽기,
# 2. n-1번째 빌딩이 n보다 작거나 같으면 2번 리스트에 append 임시 변수에 +1 n-1번째의 벤치마킹 가능한 빌딩을 그때까지의 임시변수로 표기
# 3. n-1번째 빌딩이 n보다 크면 n 버리고 임시 변수를 n-1번째 벤치마킹 가능한 빌딩으로 표기 그리고 
# 10 3 7 4 12 2 2
# 3 0 1 0 1 0 
# 10 3 7 4 12 2 2 -> 10 3 7 4 12 2 / 2,0
# 10 3 7 4 12 / 2,0 2,0 -> 10 3 7 4 / 12/+1
# 10 3 7 4 / 12/+1 -> 10 3 7 / 4 12+1
# 10 3 7 / 4 12+1 -> 10 3 / 7+1 12+1
# 10 3 / 7+1 12+1 -> 10 / 3 7+1 12+1
# 10 / 3 7+1 12+1 -> 10+3 / 12+1


N = int(sys.stdin.readline())

buildings = [0] * N
buildings_tmp = []
answer = 0
for i in range(N):
    buildings[i] = [int(sys.stdin.readline()), 0]

for i in range(N-1, -1, -1):
	current = buildings.pop()
	if len(buildings_tmp) == 0:
		buildings_tmp.append(current)
		continue
	compare = buildings_tmp[len(buildings_tmp) - 1]
	if current[0] <= compare[0]:
		buildings_tmp.append(current)
	else:
		current[1] += 1 + compare[1]
		answer += compare[1]
		buildings_tmp.pop()
		while True:
			if len(buildings_tmp) == 0:
				buildings_tmp.append(current)
				break
			compare = buildings_tmp[len(buildings_tmp) - 1]
			if current[0] <= compare[0]:
				buildings_tmp.append(current)
				break
			else:
				current[1] += 1 + compare[1]
				answer += compare[1]
				buildings_tmp.pop()
while len(buildings_tmp) != 0:
    answer += buildings_tmp.pop()[1]
print(answer)