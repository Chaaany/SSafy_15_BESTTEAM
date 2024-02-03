import sys

input = sys.stdin.readline

standard = "ChongChong"
answer_list = [standard]

N = int(input()) # 첫 번 째 N 입력

# 만난 사람 리스트 입력 받으면서 춤추는 사람 리스트 입력
for _ in range(N):
    A, B = input().split()
    if A in answer_list or B in answer_list:
        answer_list.append(A)
        answer_list.append(B)

print(len((set(answer_list))))
