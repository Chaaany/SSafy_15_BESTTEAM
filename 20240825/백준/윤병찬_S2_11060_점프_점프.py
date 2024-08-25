import sys
def dp(current_index, jump_list, dp_list, N):
    current_value = jump_list[current_index]

    if current_value == 0 or current_index >= N:
        return
    
    for i in range(1, current_value + 1):
        if current_index + i >= N:
            return
        if dp_list[current_index + i] == 0:
            dp_list[current_index + i] = dp_list[current_index] + 1
            dp(current_index + i, jump_list, dp_list, N)
        elif dp_list[current_index + i] > dp_list[current_index] + 1:
            dp_list[current_index + i] = dp_list[current_index] + 1
            dp(current_index + i, jump_list, dp_list, N)

input = sys.stdin.readline
N = int(input())

jump_list = list(map(int, input().split(' ')))

dp_list = [0] * N

dp(0, jump_list, dp_list, N)
if N == 1:
    print(0)
else:
    print(dp_list[-1] if dp_list[-1]!= 0 else -1)