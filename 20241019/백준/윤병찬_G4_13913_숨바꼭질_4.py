from collections import deque

def bfs(n, k):
    global max_point, time_list, prev_point
    
    time_list[n] = 0
    q = deque([n])

    while q:
        current = q.popleft()

        if current == k:
            path = []
            while current != -1:
                path.append(current)
                current = prev_point[current]
            path.reverse()
            return time_list[k], path
        
        for next_point in (current - 1, current + 1, current * 2):
            if 0 <= next_point < max_point and time_list[next_point] == -1:
                time_list[next_point] = time_list[current] + 1
                prev_point[next_point] = current
                q.append(next_point)

n, k = map(int, input().split())
max_point = 100001
time_list = [-1] * max_point
prev_point = [-1] * max_point
time, path = bfs(n, k)

print(time)
print(" ".join(map(str, path)))