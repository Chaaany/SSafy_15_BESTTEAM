from collections import deque

N = int(input())

init_list = enumerate(map(int, input().split()))
deque = deque(init_list)

dial = 0
answer = []
while len(deque) != 0:
    index, dial = deque.popleft()
    answer.append(index+ 1)
    if dial > 0:
        deque.rotate((dial - 1) * -1)
    else:
        deque.rotate(dial * -1)
for number in range(N):
    print(answer[number], end=" ")
    
