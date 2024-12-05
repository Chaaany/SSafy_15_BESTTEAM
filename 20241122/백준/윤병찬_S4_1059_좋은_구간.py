# 7 8 9 10 11 12 13
# a <= b < 9
# 갯수 공식: (r - n + 1) * (n - l)
# 9 < b <= 13
# 갯수 공식: (r - n)
#   X X X
#   X X X X
#   X X X X X
#   X X X X X X
#   X X X X X X X
#     X X
#     X X X
#     X X X X
#     X X X X X
#     X X X X X X
#     X X
#     X X X
#     X X X X
#     X X X X X

L = int(input())

number_list = list(map(int, input().split()))
number_list = [0] + number_list
n = int(input())

number_list.sort()

answer = 0
l, r = n, n
for i in range(len(number_list) - 1):
    if number_list[i] + 1 <= n and n <= number_list[i+1] - 1:
        l = number_list[i] + 1
        r = number_list[i+1] - 1
        break

answer = (r - n + 1) * (n - l) + (r - n)

print(answer)
