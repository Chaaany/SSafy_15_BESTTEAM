# 한 팀의 승 무 패 합은 5경기
# 승 == 패 / 무 경기 합은 짝수 = 승 + 무/2 = 15
# 승이 있을 경우 다른팀에 패가 있어야함
# 무승부가 있을 경우 서로 다른팀에 무승부가 있어야 함

import sys

input = sys.stdin.readline

fighting_result = [[0 for _ in range(18)] for _ in range(4)]
for i in range(4):
    fighting_result[i] = list(map(int, input().split()))
# print(fighting_result)
fighting_result_1 = [[0 for _ in range(3)] for _ in range(4)]  # 승, 무, 패
fighting_result_2 = [[0 for _ in range(6)] for _ in range(4)]  # 팀 당
fighting_result_3 = [[0 for _ in range(3)] for _ in range(4)]  # 승, 무, 패
for i in range(len(fighting_result)):
    for j in range(len(fighting_result[i])):
        fighting_result_1[i][j % 3] += fighting_result[i][j] # 승, 무, 패
        fighting_result_2[i][j // 3] += fighting_result[i][j] # 팀 별 승, 무, 패 합
        if fighting_result[i][j] != 0:
            fighting_result_3[i][j % 3] += 1


for i in range(4):
    if fighting_result_1[i][0] == fighting_result_1[i][2] and fighting_result_1[i][1] % 2 == 0 and fighting_result_1[i][0] + fighting_result_1[i][1] / 2 == 15 and all(val == 5 for val in fighting_result_2[i]) and ((fighting_result_3[i][0] != 0 and fighting_result_3[i][2] != 0) or (fighting_result_3[i][0] == 0 and fighting_result_3[i][2] == 0)) and fighting_result_3[i][1] != 1:
        # print(fighting_result_1)
        # print(fighting_result_2)
        print(1, end=" ")
    else:
        print(0, end=" ")
    # print(fighting_result_1)
    # print(fighting_result_2)
    # print(fighting_result_3)






