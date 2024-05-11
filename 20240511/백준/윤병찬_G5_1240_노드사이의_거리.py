import sys

def bfs(a, b):
    global graph

    q = []
    q.append((a, 0))
    visited = [False] * (N + 1)
    visited[a] = True

    while q:
        v, d = q.pop(0)
        
        if v == b:
            return d
        
        for i, j in graph[v]:
            if not visited[i]:
                visited[i] = True
                q.append((i, d + j))

input = sys.stdin.readline
N, M = map(int, input().split())

graph = [[] for _ in range(N + 1)] # padding

for _ in range(N-1):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

for _ in range(M):
    a, b = map(int, input().split())
    print(bfs(a, b))