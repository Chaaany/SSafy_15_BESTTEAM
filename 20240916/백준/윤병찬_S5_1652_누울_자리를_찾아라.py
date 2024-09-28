n = int(input())  
room = [input() for _ in range(n)]

row_count = 0
for i in range(n):
    empty_space = 0
    for j in range(n):
        if room[i][j] == '.':
            empty_space += 1
        else:
            if empty_space >= 2:
                row_count += 1
            empty_space = 0
    if empty_space >= 2:
        row_count += 1

col_count = 0
for i in range(n):
    empty_space = 0
    for j in range(n):
        if room[j][i] == '.':
            empty_space += 1
        else:
            if empty_space >= 2:
                col_count += 1
            empty_space = 0
    if empty_space >= 2:
        col_count += 1

print(row_count, col_count)
