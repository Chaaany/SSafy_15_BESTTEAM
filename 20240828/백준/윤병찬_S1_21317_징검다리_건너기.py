# 돌 N개
# N - 1
# 점프 1, 2, 3
def jump(stone_list, current_stone, used_energy, target_stone, super_jump_energy, did_super_jump=False):
    if current_stone == target_stone:
        global min_energy
        min_energy = min(used_energy, min_energy)
        return

    if current_stone > target_stone:
        return

    small_jump_next_stone = current_stone + 1
    small_jump_next_used_energy = used_energy + stone_list[current_stone][0]
    jump(stone_list, small_jump_next_stone, small_jump_next_used_energy, target_stone, super_jump_energy, did_super_jump)
    
    big_jump_next_stone = current_stone + 2
    big_jump_next_used_energy = used_energy + stone_list[current_stone][1]
    jump(stone_list, big_jump_next_stone, big_jump_next_used_energy, target_stone, super_jump_energy, did_super_jump)
    
    if not did_super_jump:
        super_jump_next_stone = current_stone + 3
        super_jump_next_used_energy = used_energy + super_jump_energy
        jump(stone_list, super_jump_next_stone, super_jump_next_used_energy, target_stone, super_jump_energy, True)
    

N = int(input())

stone_list = [[0, 0]]
min_energy = float('inf')

for _ in range(N - 1):
    tmp = list(map(int, input().split(' ')))
    stone_list.append(tmp)

K = int(input())

jump(stone_list, 1, 0, N, K, False)

print(min_energy)

