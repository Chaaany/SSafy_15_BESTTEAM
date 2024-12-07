# 케이스
import sys
input = sys.stdin.readline
L = int(input())
M_L, M_K = map(int, input().split())
C_ammo = int(input())
answer = ''
shooting_count = 1
for i in range(L):
    answer = 'NO'
    zombie_HP = int(input())
    if zombie_HP <= M_K * shooting_count:
        shooting_count += 1
        answer = 'YES'
        continue
    if zombie_HP > M_K * shooting_count and C_ammo >= 1:
        C_ammo -= 1
        answer = 'YES'
        continue

print(answer)