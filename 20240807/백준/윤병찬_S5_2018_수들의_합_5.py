# 짝수로 나눴을때 x.5 &&  몫 - 분모/2 >= 0
# 홀수로 나눴을때 나누어 떨어져야함 &  몫 - 분모 // 2 > 0

def is_decimal_half(numerator, denominator):
    result = numerator / denominator
    return result % 1 == 0.5 and numerator // denominator - denominator // 2 >= 0

N = int(input())
count = 1
for denominator in range(2, N+1):
    if denominator % 2 == 0: # 짝수
        count += 1 if is_decimal_half(N, denominator) else 0
        # print("count: ", count, "denominator: ", denominator )
    elif N % denominator == 0 and N // denominator - denominator // 2 > 0: # 홀수
        count += 1
        # print("count: ", count, "denominator: ", denominator )
print(count)
