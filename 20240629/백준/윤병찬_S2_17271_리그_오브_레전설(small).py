N, B = map(int, input().split())

sum = [0] * (N + 1)

sum[0] = 1

for i in range(1, N + 1):
    if i < B:
        sum[i] = sum[i - 1]
    else:
        sum[i] = (sum[i - 1] + sum[i - B]) % 1000000007

print(sum[N])
