import heapq

N, M, K = list(map(int, input().split()))
beer_list = []
for _ in range(K):
    V, C = map(int, input().split())
    beer_list.append([C, V])

heapq.heapify(beer_list)

drunk_beer_list = []
sum_K = 0

for _ in range(K):
    value_temp = heapq.heappop(beer_list)
    C, V = value_temp[0], value_temp[1]
    sum_K += V
    heapq.heappush(drunk_beer_list, V)

    if len(drunk_beer_list) > N:
        value = heapq.heappop(drunk_beer_list)
        sum_K -= value
    if len(drunk_beer_list) == N and sum_K >= M:
        print(C)
        exit(0)    

print(-1)