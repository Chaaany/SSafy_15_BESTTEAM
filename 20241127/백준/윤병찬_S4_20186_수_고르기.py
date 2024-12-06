# 높은 순 정렬
# 높은 순부터 더해서 K 빼기
# 1 = 0, 2 = 0 + 1, 3 = 0 + 1 + 2, 4 = 0 + 1 + 2 + 3 = n * (n-1) / 2
N, K = map(int, input().split())

number_list = list(map(int, input().split()))

number_list.sort(reverse=True)

answer = 0

for i in range(K):
    answer += number_list[i]
    
answer -= int(K * (K - 1) / 2)
print(answer)