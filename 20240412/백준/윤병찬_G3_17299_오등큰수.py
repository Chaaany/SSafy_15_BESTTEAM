# F(A)   = 3 3 2 1 1 2 3
# A      = 1 1 2 3 4 2 1

# NGF(A) = -1 -1 1 2 2 1 -1


N = int(input().strip())
A = list(map(int, input().split()))
F_A = [0] * (1000000 + 1)
NGF = [-1] * N # 초기화를 -1로 해두기
stack = []
for i in range(N): # F(A) 구성
    F_A[A[i]] += 1

for i in range(N):
    cur_number = A[i]
    while stack and F_A[cur_number] > F_A[A[stack[-1]]]: # stack에 비교 index 미처리 index가 존재하며 현재 인덱스보다 stack에 있는 인덱스의 F(A)값이 더 클 경우 업데이트
        NGF[stack.pop()] = cur_number
    stack.append(i)
for i in range(N):
    print(NGF[i], end=" ")
    