from collections import deque

def min_operations(a, b):
    queue = deque([(a, 0)])
    visited = set()  
    
    while queue:
        current, operations = queue.popleft()
        
        if current == b:
            return operations
        
        if current < b:
            if current + 1 not in visited:
                visited.add(current + 1)
                queue.append((current + 1, operations + 1))
            if current * 2 not in visited:
                visited.add(current * 2)
                queue.append((current * 2, operations + 1))

a, b = map(int, input().split())

print(min_operations(a, b))