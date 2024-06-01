# 입력을 받는 부분
rows, cols = map(int, input().split())
grid = [input() for _ in range(rows)]

max_side_length = min(rows, cols)  # 정사각형 한 변의 최대 길이
largest_square_side = 1    # 최소 정사각형의 크기 1 (1x1)

# 가능한 정사각형의 크기를 줄여가며 확인
for size in range(max_side_length, 0, -1):
    for row in range(rows - size + 1):
        for col in range(cols - size + 1):
            if (grid[row][col] == grid[row][col + size - 1] and
                grid[row][col] == grid[row + size - 1][col] and
                grid[row][col] == grid[row + size - 1][col + size - 1]):
                largest_square_side = size
                break
        if largest_square_side == size:
            break
    if largest_square_side == size:
        break

print(largest_square_side ** 2)