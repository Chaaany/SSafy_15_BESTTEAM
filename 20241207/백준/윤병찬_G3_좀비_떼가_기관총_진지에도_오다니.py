# 진지 앞쪽 거리 = Lm ( 1 ~ 3 x 10^6 )
# 기관총 살상력 = K( 1 ~ 100 )
# 사거리 = M_L(1 ~ 3 x 10^6 )
# im의 좀비 체력 Z_i 
# 체력 0이하 = 죽음


# X X X
#   1 1 1
#     1 1 1
#       X X X
#         X X X




# 1 1 1
#   1 1 1
#     1 1 1
#       1 1 1
#         X X X
#           1 1 1
#             1 1 1 
#               1 1 1 
#                 X X X
#                   1 1 1
# 케이스
import sys
input = sys.stdin.readline
L = int(input())
M_L, M_K = map(int, input().split())
C_ammo = int(input())
answer = 'YES'

total_damage = [0]

for zombie_distance in range(1, L + 1):
    # 초반 사거리 내의 좀비
    zombie_HP = int(input())
    damage = total_damage[zombie_distance - 1] - total_damage[max(0, zombie_distance - M_L)]
        
    if zombie_HP <= damage + M_K:
        total_damage.append(total_damage[zombie_distance - 1] + M_K)
        continue
    if C_ammo > 0:
        total_damage.append(total_damage[zombie_distance - 1])
        C_ammo -= 1
        continue
    answer = 'NO'
    break
print(answer)