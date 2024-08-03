n = int(input())
level_list = list(map(int, input().split()))
level_list.sort(reverse=True)
ans = 0

for i in range(len(level_list)-1):
    i = 0
    ans += level_list[i] + level_list[i+1]
    del level_list[i+1]

print(ans)