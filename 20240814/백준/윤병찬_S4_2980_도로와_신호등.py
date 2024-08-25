# 신호등 지나갈 지 말 지 로직
# 대기해야하는 경우: 특정 신호등에서의 소요 시간 % ( R + G ) < R 
# -> 대기 해야 하는 시간: R - 특정 신호등에서의 소요 시간  % (R + G) 
# 대기할 필요 없는 경우: 특정 신호등에서의 소요 시간 % ( R + G ) >= R
    #   X   X
# 0 1 2 3 4 5 6 7 8 9 10
# 0 1 2 5 6 7 8 9 10 11 12



def should_wait_trafic_light(total_spent_time, current_traffic_light_index, traffic_light_list):
    total_traffic_light_spent_time = traffic_light_list[current_traffic_light_index][1] + traffic_light_list[current_traffic_light_index][2]
    tmp_time = total_spent_time % ( total_traffic_light_spent_time )
    if tmp_time < traffic_light_list[current_traffic_light_index][1]:
        return (True, traffic_light_list[current_traffic_light_index][1] - tmp_time)
    else:
        return (False, 0)


N, L = map(int, input().split(' '))

traffic_light_list = [[0, 0, 0]]

for _ in range(N):
    traffic_light_list.append(list(map(int, input().split(' '))))

total_spent_time = 0

for i in range(1, len(traffic_light_list)):
    spent_time = traffic_light_list[i][0] - traffic_light_list[i - 1][0] # 신호등 간의 소요시간
    total_spent_time += spent_time
    flag, wait_time = should_wait_trafic_light(total_spent_time, i, traffic_light_list)
    if flag:
        total_spent_time += wait_time

print(total_spent_time + L - traffic_light_list[N][0])

