# 목표 거리 < jump_distance
# 1. jump_distance / jump_time > 1 일 경우 
# - 두 번 뛰기 or 뛰고/걷기 or 걷기
# 2. jump_distance / jump_time <= 1 일 경우 
# - 걸음 = 목표거리
# 목표 거리 == jump_distance
# 1. jump_distance / jump_time > 1 일 경우 
# - 뛰기 
# 2. jump_distance / jump_time <= 1 일 경우 
# - 걸음 = 목표거리

# 목표 거리 > jump_distance
# 1. jump_distance / jump_time > 1 일 경우 
# 목표 거리가 점프의 배수일 경우 
# - 뛰기 목표거리 // jump_distance 번 뛰기
# 목표 거리가 점프의 배수가 아닐 경우
# - 뛰기 목표거리 // jump_distance + 1번 뛰기 or jump_distance + 남은 거리 걷기
# 2. jump_distance / jump_time <= 1 일 경우 
# - 걸음 = 목표거리


import sys

dest_x, dest_y, jump_distance, jump_time = map(int, sys.stdin.readline().split())

dest_distance = (dest_x ** 2 + dest_y ** 2) ** 0.5

if dest_distance < jump_distance:
    spare_distance = jump_distance - dest_distance
    print( min(2 * jump_time, jump_time + spare_distance, dest_distance))
elif dest_distance == jump_distance:
    print( min(jump_time, dest_distance))
else:
    min_total_jump_count = dest_distance // jump_distance
    if dest_distance % jump_distance == 0:
        spare_distance = dest_distance - min_total_jump_count * jump_distance
        print(min(min_total_jump_count * jump_time + spare_distance, dest_distance))
    else: 
        spare_distance = dest_distance - min_total_jump_count * jump_distance
        print(min((min_total_jump_count + 1) * jump_time, min_total_jump_count * jump_time + spare_distance, dest_distance))