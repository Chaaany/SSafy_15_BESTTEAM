import heapq, sys

def dijkstra(num_nodes, edges, start_node):
    # 그래프 초기화
    graph = {i: [] for i in range(1, num_nodes + 1)}
    for u, v, w in edges:
        graph[u].append((v, w))

    # 최단 거리 테이블을 무한대로 초기화
    distances = {i: float('inf') for i in range(1, num_nodes + 1)}
    distances[start_node] = 0

    # 우선순위 큐 초기화
    priority_queue = [(0, start_node)]  # (거리, 노드)
    
    while priority_queue:
        current_distance, current_node = heapq.heappop(priority_queue)

        if current_distance > distances[current_node]:
            continue

        for neighbor, weight in graph[current_node]:
            distance = current_distance + weight

            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(priority_queue, (distance, neighbor))

    return distances

input = sys.stdin.readline
num_nodes, num_edges = map(int, input().split())
start_node = int(input())
edges = []

for _ in range(num_edges):
    u, v, w = map(int, input().split())
    edges.append((u, v, w))

shortest_distances = dijkstra(num_nodes, edges, start_node)
for node in range(1, num_nodes + 1):
    print(shortest_distances[node])