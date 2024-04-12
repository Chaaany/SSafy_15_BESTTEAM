

r, c = map(int, input().split())
k = int(input().strip())
room = [[0 for _ in range(c)] for _ in range(r)]
cmd = [[0, 0], [-1, 0], [1, 0], [0, -1], [0, 1]] # 상, 하, 좌, 우

for _ in range(k): # 장애물 표기
    block_r, block_c = map(int, input().split())
    room[block_r][block_c] = 1

start_r, start_c = map(int, input().split())
cmd_line = list(map(int, input().split()))

room[start_r][start_c] = 1
cur_r, cur_c = start_r, start_c
cmd_line_number = 0
cmd_line_len = len(cmd_line)
record_cmd_line_number = 0
while True:
    cur_cmd = cmd[cmd_line[cmd_line_number]]
    while True:
        next_r, next_c = cur_r + cur_cmd[0], cur_c + cur_cmd[1]
        if (next_r >= 0 and next_c >= 0) and (next_r < r and next_c < c) and room[next_r][next_c] != 1:
            room[next_r][next_c] = 1
            cur_r, cur_c = next_r, next_c
            record_cmd_line_number = cmd_line_number % cmd_line_len
        else:
            cmd_line_number = (cmd_line_number + 1) % cmd_line_len
            break
    if cmd_line_number == record_cmd_line_number:
        break
            

print(cur_r, cur_c)
