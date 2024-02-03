# 각 지방의 예산 입력 받으면서 누적합 해둠 커봐야 10000 * 10001 / 2 임
# 각 지방의 예산 정렬 - 가장 큰 것부터 부여해봄
# 누적합에서 빼고, 예산 * 뺀 것들 갯수를 누계함 - > 남는 경우에 뺀 것들의 갯수만큼 나눠서 부여하면됨

import sys

input = sys.stdin.readline

N = int(input())
budgets = list(map(int, input().split()))
budgets.sort()
M = int(input())
total_budgets = sum(budgets)

count = 0
while 1:
    if total_budgets > M and count <= len(budgets) -1:
        total_budgets -= budgets[len(budgets) - count - 1] * (count + 1)
        # print(count, total_budgets)
        count+=1
        total_budgets += budgets[len(budgets) - count - 1] * count
        # print(count, total_budgets)
    else:
        if count == 0:
            print(max(budgets))
            break
        elif total_budgets <= 0:
            print(1)
            break
        else:
            # print(total_budgets, M, budgets[len(budgets)-count-1])
            print((M - total_budgets) // count + budgets[len(budgets)-count-1])
            break
