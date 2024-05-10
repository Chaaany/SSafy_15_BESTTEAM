# def push_left(X):
#     global deque
#     new_deque = [X]
#     new_deque += deque 
#     deque = new_deque
    
# def push_right(X):
#     global deque
#     deque.append(X)

# def check_int_and_pop_left():
#     global deque
#     if not deque:
#         print(-1)
#     else:
#         print(deque.pop(0))
    
# def check_int_and_pop_right():
#     global deque
#     if not deque:
#         print(-1)
#     else:
#         print(deque.pop(len(deque) - 1))

# def check_int():
#     global deque
#     print(len(deque))

# def check_empty():
#     global deque
#     if not deque:
#         print(1)
#     else:
#         print(0)
        
# def check_int_and_print_left():
#     global deque
#     if not deque:
#         print(-1)
#     else:
#         print(deque[0])
        
# def check_int_and_print_right():
#     global deque
#     if not deque:
#         print(-1)
#     else:
#         print(deque[len(deque) - 1])
    
# deque = []

# import sys

# input = sys.stdin.readline

# N = int(input())

# for i in range(N):
#     cmd = list(map(int, input().split()))
    
#     if cmd[0] == 1:
#         push_left(cmd[1])
#     elif cmd[0] == 2:
#         push_right(cmd[1])
#     elif cmd[0] == 3:
#         check_int_and_pop_left()
#     elif cmd[0] == 4:
#         check_int_and_pop_right()
#     elif cmd[0] == 5:
#         check_int()
#     elif cmd[0] == 6:
#         check_empty()
#     elif cmd[0] == 7:
#         check_int_and_print_left()
#     elif cmd[0] == 8:
#         check_int_and_print_right()


import collections
import sys

deque = collections.deque()

input = sys.stdin.readline

N = int(input())

for i in range(N):
    cmd = list(map(int, input().split()))
    
    if cmd[0] == 1:
        deque.appendleft(cmd[1])
    elif cmd[0] == 2:
        deque.append(cmd[1])
    elif cmd[0] == 3:
        print(deque.popleft() if deque else -1)
    elif cmd[0] == 4:
        print(deque.pop() if deque else -1)
    elif cmd[0] == 5:
        print(len(deque))
    elif cmd[0] == 6:
        print( 0 if deque else 1)
    elif cmd[0] == 7:
        print( deque[0] if deque else -1)
    elif cmd[0] == 8:
        print( deque[len(deque) - 1] if deque else -1)