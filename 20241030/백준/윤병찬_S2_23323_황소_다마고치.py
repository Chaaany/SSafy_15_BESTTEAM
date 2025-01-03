# 7 -> 3
# 3 -> 1
# 2 -> 1
# 1 -> 0

# 2의 지수 + 먹이 = 답

def find_exponent(n):
    count = 0
    while n > 0:
        n //= 2
        count += 1
    return count

T = int(input())

answer = []
for _ in range(T):
    n, m = map(int, input().split())
    answer.append(find_exponent(n) + m)
    
print("\n".join(map(str, answer)))
