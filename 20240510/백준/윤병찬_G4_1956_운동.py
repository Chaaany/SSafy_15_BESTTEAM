# Vertex(400), Edge(399 * 400) 방향 그래프 1 <= c <= 10000

import sys

input = sys.stdin.readline

V, E = map(int, input().split())

graph = [[int(1e9)] * (V + 1) for _ in range(V + 1)] # padding

for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a][b] = c


for i in range(1, V + 1):
    for j in range(1, V + 1):
        for k in range(1, V + 1):
            if graph[j][i] + graph[i][k] < graph[j][k]:
                graph[j][k] = graph[j][i] + graph[i][k]

answer = 1e9
for i in range(1, V + 1):
    answer = min(answer, graph[i][i])
    
print(answer if answer != 1e9 else -1)
