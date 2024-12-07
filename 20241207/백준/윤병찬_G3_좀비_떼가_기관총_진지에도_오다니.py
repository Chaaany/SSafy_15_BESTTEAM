# 케이스
import sys
input = sys.stdin.readline
L = int(input())
M_L, M_K = map(int, input().split())
C_ammo = int(input())
answer = 'YES'
shooting_count = 1
use_ammo_count = 0
zombie_distance = 0
for _ in range(L):
    zombie_distance += 1
    zombie_HP = int(input())
    if zombie_distance <= M_L: # 초반 유효사거리 좀비 대상
        if zombie_HP <= M_K * (shooting_count - use_ammo_count): # 기관총 살상 가능
            shooting_count += 1
            if use_ammo_count != 0:
                use_ammo_count -= 1
            continue
        if C_ammo >= 1: # 기관총 살상 불가, 수류탄 살상 가능
            C_ammo -= 1
            use_ammo_count += 1
            continue
        answer = 'NO'
        break
    else: # 후반 유효사거리 좀비 대상
        if zombie_HP <= M_K * (shooting_count - use_ammo_count): 
            if use_ammo_count != 0:
                use_ammo_count -= 1
            continue
        if C_ammo >= 1: # 기관총 살상 불가, 수류탄 살상 가능
            use_ammo_count += 1
            continue
        answer = 'NO'
        break

print(answer)