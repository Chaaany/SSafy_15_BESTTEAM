# a -> b / b 감염 -> a 감염


# b -> a 시간의 최솟값을 배열에 업데이트 해놓기 그중 max값



def hack(computer_number, prev_sec):
    global node
    global c
    global hacked_time
    com_list = node[computer_number]
    for computer in com_list:
        hacked_time[computer[0]][0] =  min(hacked_time[computer[0]][0], prev_sec + computer[1])
        hacked_time[computer[0]][1] = True
        hack(computer[0], computer[1])

case_count = int(input())

for case in range(case_count):
    n, d, c = map(int, input().split())
    node = [[0, 0] for _ in range(n+1)]
    hacked_time = [[1000000000, False] for _ in range(n + 1)]
    # 케이스 받아서 그래프로 표현
    for i in range(n):
        a, b, sec = map(int, input().split())
        node[b].append([a, sec])
    hack(c, 0)
    count = 0
    for i in range(1, n+1):
        if hacked_time[i][1]:
            count+=1
            max = max(hacked_time[i][0], max)
        else:
            continue
    print(count, max)