import sys

N = int(sys.stdin.readline())

numbers = []


for i in range(N):
    a = int(sys.stdin.readline().strip())
    numbers.append([a, i])
    
numbers.sort(key=lambda x: x[0])
answer = 0

for i in range(N):
    answer = max(numbers[i][1] - i, answer)

print(answer+1)
