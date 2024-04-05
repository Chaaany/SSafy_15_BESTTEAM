# 과제를 받을 때 채워넣음
# 뒤에서부터 순회를 돌며(시간을 보냄) 과제가 있을 경우 해당 과제를 완료할 수 있으면 완료 시킴 + 점수를 합산함, 남은 시간 누적 / 완료할 수 없으면 해당 과제에서 시간 제외
# 1. 할 과제가 없고 과제를 받지 않은 경우
# 2. 할 과제가 없고 과제를 받은 경우
# 3. 할 과제가 있고 과제를 받지 않은 경우
# 4. 할 과제가 있고 과제를 받은 경우

import sys

task, result = [], 0
for _ in range(int(sys.stdin.readline())):
    new_task = list(map(int,sys.stdin.readline().split()))
    if new_task[0] == 1:
        task.append((new_task[1], new_task[2]))
    
    if task:
        score, time = task.pop()
        time -= 1
        if time == 0:
            result += score
        else:
            task.append((score,time))
print(result)