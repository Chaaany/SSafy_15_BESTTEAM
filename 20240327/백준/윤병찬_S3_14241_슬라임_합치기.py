import heapq, sys

pq = []

N = int(sys.stdin.readline())

pq = list(map(int, sys.stdin.readline().split()))
pq = [-x for x in pq]

total = 0
while len(pq) > 1:
    a = heapq.heappop(pq) * -1
    b = heapq.heappop(pq) * -1
    total += a * b
    heapq.heappush(pq, -1 * (a + b))
    
print(total)