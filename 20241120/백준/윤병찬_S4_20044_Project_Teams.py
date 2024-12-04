# 정렬하기
# 양끝 더해서 최솟값 비교
# n번 반복, 포인터 둘다 +1, -1

N = int(input())

num_list = list(map(int, input().split()))
num_list.sort()
answer = 200000

for i in range(N):
    answer = min(num_list[i] + num_list[2 * N - 1 - i], answer)
print(answer)