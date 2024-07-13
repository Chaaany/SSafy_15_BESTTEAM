def count_number(n):
    if n == 1:
        return 1
    elif n == 2:
        return 1
    
    dp = [0] * (n + 1)
    dp[1] = 1
    dp[2] = 1

    for i in range(3, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

    return dp[n]

n = int(input())
print(count_number(n))
