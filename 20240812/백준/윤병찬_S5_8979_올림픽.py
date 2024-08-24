import sys

input = sys.stdin.readline

N, K = map(int, input().split(' '))
received_medal_list = []

for _ in range(N):
    tmp_received_medal = list(map(int, input().split(' ')))
    received_medal_list.append(tmp_received_medal)

received_medal_list.sort(key=lambda x: (-x[0], -x[1], -x[2]))

target_index = 0
for i in range(N):
    if received_medal_list[i][0] == K:
        target_index = i

rank = 1
for i in range(target_index):
    if not(received_medal_list[i][1] == received_medal_list[target_index][1] and received_medal_list[i][2] == received_medal_list[target_index][2]):
        rank += 1

print(rank)


