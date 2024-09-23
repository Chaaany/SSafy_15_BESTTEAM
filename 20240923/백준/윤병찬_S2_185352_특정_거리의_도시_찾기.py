# bfs
# 다익스트라

def bfs(depth, queue):
    global K, visited
    if not queue or depth == K + 1:
        return queue
    
    next_node_queue = []
    while queue:
        cur_node = queue.pop(0)
        for next_node in graph[cur_node]:
            if not visited[next_node]:
                visited[next_node] = True
                next_node_queue.append(next_node)
    return bfs(depth + 1, next_node_queue)
    
N, M, K, X = map(int, input().split())

graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)

visited = [False] * (N + 1)
visited[X] = True
queue = [X]

result = bfs(1, queue)
if result:
    result = tuple(result)
    result = list(result)
    result.sort()
    for node in result:
        print(node)
else:
    print(-1)