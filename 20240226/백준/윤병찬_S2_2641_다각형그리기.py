# 먼저 모양 수열의 케이스를 확보 -> 많아봐야 200개 -> 반대방향
import sys, copy


def rotate_list(lst):
    global spare
    length = len(lst)
    # 리스트의 길이만큼 반복하여 로테이션 수행
    for _ in range(length):
        lst.insert(0, lst.pop())
        spare.append(copy.copy(lst))

def transform_numbers(lst):
    # 숫자를 변환하는 딕셔너리
    transformation_dict = {1: 3, 2: 4, 3: 1, 4: 2}

    # 리스트의 각 요소를 변환하여 새로운 리스트에 저장
    transformed_list = [transformation_dict[num] if num in transformation_dict else num for num in lst]

    return transformed_list

input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

spare = []
rotate_list(A)

A = transform_numbers(A)
A = A[::-1]
rotate_list(A)

M = int(input())
answer = []
answer_count = 0
for _ in range(M):
    temp = list(map(int, input().split()))
    if temp in spare:
        answer_count += 1
        answer.append(temp)

print(answer_count)
for i in range(answer_count):
    for j in range(len(answer[i])):
        print(answer[i][j], end=" ")
    print()

