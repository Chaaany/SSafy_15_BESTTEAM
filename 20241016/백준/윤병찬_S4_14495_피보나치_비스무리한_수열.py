def fake_fibonacci(n):
    if n <= 3:
        return 1
    dp = [0] * (n + 1)
    dp[1], dp[2], dp[3] = 1, 1, 1
    for i in range(4, n + 1):
        dp[i] = dp[i - 1] + dp[i - 3]
    return dp[n]

n = int(input())
print(fake_fibonacci(n))