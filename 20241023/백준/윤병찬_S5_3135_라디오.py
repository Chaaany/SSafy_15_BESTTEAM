
a, b = map(int, input().split())
n = int(input())
favorites = [int(input()) for _ in range(n)]

min_step = abs(b - a)

for favorite in favorites:
    steps = abs(b - favorite) + 1 
    min_step = min(min_step, steps)

print(min_step)