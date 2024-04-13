import sys
# 큰수가 스택에 젤 위에 있어야 함
# 4 / 6 / 7 / 8 / 9 / 10 // 3  // 2  // 1 / 5
input = sys.stdin.readline
N = int(input())

four_stack = [[] for i in range(4)]

A = list(map(int, input().split()))
while A:
    for j in range(4): # 스택 순회하며 넣을 수 있는지 확인
        if four_stack[j] and four_stack[j][-1] < A[0]:
            four_stack[j].append(A.pop(0))
            chk = True
            break
        elif not four_stack[j]:
            four_stack[j].append(A.pop(0))
            chk = True
            break
        chk = False
    if not chk:
        break

if not A:
    print("YES")
else:
    print("NO")

        