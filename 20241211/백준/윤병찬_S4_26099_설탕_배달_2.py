N = int(input())

answer = 0
while N % 5 != 0 and N >= 0:
    N -= 3
    answer += 1
if N >= 0:
    print(answer + N // 5)
else:
    print(-1)
    
