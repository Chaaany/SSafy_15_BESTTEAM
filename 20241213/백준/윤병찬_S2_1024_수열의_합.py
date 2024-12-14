# 짝수 + 짝수 = 짝수
# 홀수 + 짝수 = 홀수
# 홀수 + 홀수 = 짝수
# 짝수 + 홀수 + 짝수 + 홀수 = 짝수
# 누적합 -> 999,999,900 이므로 불가
# i * (i - 1) / 2 - j * (j - 1) / 2 = N
#  2 =< L = i - j +1 <= 100

def find_sequence(N, L):
    for length in range(L, 101):  # 최소 L에서 최대 100까지 시도
        # 연속된 자연수의 합 공식: (x + x+1 + ... + x+(length-1)) = length * x + (0+1+...+(length-1))
        # 따라서, x = (N - length*(length-1)//2) / length
        x = (N - (length * (length - 1)) // 2) / length
        if x.is_integer() and x >= 0:
            x = int(x)
            return list(range(x, x + length))
    return -1  # 찾을 수 없으면 -1 반환

# 입력 받기
N, L = map(int, input().split())

# 결과 출력
result = find_sequence(N, L)
if result == -1:
    print(-1)
else:
    print(' '.join(map(str, result)))



# 1. 수열 생성 가능 여부 확인
# 홀수로는 나머지가 없고, 나누어떨어지면 되고, 짝수로는 .5로 나누어떨어져야 함 
# 2.1 홀수
# 나누는 수 3, 나눌 수 3, 몫: 1
# 수열 시작 몫 - 나눌 수 // 2 ~ + 나누는 수 - 1
# 2.2 짝수
# 나누는 수 4, 나눌 수 6, 몫: 1, 
# 수열 시작 몫 - 나눌 수 // 2 ~ + 나누는 수  - 1 

N, L = map(int, input().split())

for i in range(L, min(101, N)):
    A = N / i
    B = N // i
    C = N % i
    if i % 2 == 0 and A - B == 0.5 and B - i // 2 >= 0 : # 나누는 수가 짝수
        for j in range(B - i // 2 + 1, B - i // 2 + i):
            print(j, end=" ")
        exit(0)
    elif i % 2 != 0 and C == 0 and B - i // 2 >= 0: # 나누는 수가 홀수
        for j in range(B - i // 2, B - i // 2 + i):
            print(j, end=" ")
        exit(0)
print(-1)

