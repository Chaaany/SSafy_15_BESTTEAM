def count_trailing_zeros(n):
    count = 0
    while n >= 5:
        count += n // 5
        n //= 5
    return count
T = int(input())
for _ in range(T):
    n = int(input())
    print(count_trailing_zeros(n))

