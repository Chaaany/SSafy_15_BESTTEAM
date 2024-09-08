def get_menu(menu_list, m):
    min_diff = 1000000000000000000000000
    min_value = 1000000000000000000000000000
    x, y = -1, -1
    for i in range(61):
        for j in range(i, 61):
            if abs(menu_list[i][j] - m) < min_diff:
                min_diff = abs(menu_list[i][j] - m)
                min_value = menu_list[i][j]
                # print("1: ", "m: ", m, "min_diff: ", min_diff, "min_value: ", min_value, "i: ", i, "j: ", j)
                x, y = i, j
            elif abs(menu_list[i][j] - m) == min_diff and menu_list[i][j] < min_value:
                min_value = menu_list[i][j]
                x, y = i, j
                # print("2: ", "m: ", m, "min_diff: ", min_diff, "min_value: ", min_value, "i: ", i, "j: ", j)
    return x, y


menu_list = [[0] * 61 for _ in range(61)]

for i in range(61):
    for j in range(i, 61):
        menu_list[i][j] = (1 << i) + (1 << j)
n = int(input())
for _ in range(n):
    m = int(input())
    answer_x, answer_y = get_menu(menu_list, m)
    print(answer_x, answer_y)

