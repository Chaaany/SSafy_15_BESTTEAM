import sys

def min_cost(n, m, memory, cost):
    max_cost = sum(cost) + 1
    dp = [[0] * (max_cost) for _ in range(n+1)]

    for i in range(1, n+1):
        for j in range(max_cost):
            if cost[i-1] <= j:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-cost[i-1]] + memory[i-1])
            else:
                dp[i][j] = dp[i-1][j]

    for j in range(max_cost):
        if dp[n][j] >= m:
            return j

if __name__ == "__main__":
    input = sys.stdin.readline

    n, m = map(int, input().split())
    memory = list(map(int, input().split()))
    cost = list(map(int, input().split()))

    result = min_cost(n, m, memory, cost)
    print(result)
