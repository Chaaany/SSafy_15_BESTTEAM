import sys

input = sys.stdin.readline

N, K = map(int, input().split(' '))
received_medal_list = []

for _ in range(N):
    tmp_received_medal = list(map(int, input().split(' ')))
    received_medal_list.append(tmp_received_medal)

received_medal_list.sort(key=lambda x: (-x[1], -x[2], -x[3]))

target_index = 0
for i in range(N):
    if received_medal_list[i][0] == K:
        target_index = i

rank = 1
received_medal_list[0].append(rank)
for i in range(1, N):
    rank += 1
    if received_medal_list[i - 1][1] == received_medal_list[i][1] and received_medal_list[i - 1][2] == received_medal_list[i][2] and received_medal_list[i - 1][3] == received_medal_list[i][3]:
        received_medal_list[i].append(received_medal_list[i - 1][4])
    else:
        received_medal_list[i].append(rank)
    
print(received_medal_list[target_index][4])
