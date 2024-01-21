# 1. 한 팀 당 선수는 여섯명으로 이루어져야만 함
# 2. 최소 한 팀은 정상
# 3. 점수가 동일한 팀이 있을 경우 5번째 주자를 기준으로 등수 선정함
#
# 1. 입력 받는 순간에 정상 팀인지 알 수 있나?
# -> X  다 입력 받고나서 점수 산정을 해야함
# 2. 다 입력 받고 점수 산정하며 합산 해두고, 5등의 점수 확인
from collections import defaultdict

t = int(input())

for _ in range(t):
    n = int(input())
    record = list(map(int, input().split()))
    # 정상적인 팀 확인
    check = [x for x in range(201) if record.count(x) == 6]
    sum_score = defaultdict(list, {i: [0, 0, 0] for i in range(201)})
    score = 0
    # 팀당 점수 합산(4등까지), 5등 점수일 경우 저장
    # 0: 총 점수 / 1: 팀의 등번호 / 2: 각 팀의 다섯번 째 선수 점수
    for i, item in enumerate(record):
        if item in check:
            sum_score[item][1] += 1
            if sum_score[item][1] <= 4:
                sum_score[item][0] += score + 1
            elif sum_score[item][1] == 5:
                sum_score[item][2] = i + 1
            score += 1
    win = sum_score[check[0]][0]
    answer = [check[0], sum_score[check[0]][2]]
    # print(sum)
    for i in check:
        # print(i, sum_score[i][0])
        if min(win, sum_score[i][0]) == sum_score[i][0] and sum_score[i][2] < answer[1]:
            answer = [i, sum_score[i][2]]
        win = min(win, sum_score[i][0])
    print(answer[0])

