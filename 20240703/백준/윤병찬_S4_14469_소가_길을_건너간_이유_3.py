def calc_min_time(n, arrivals, inspections):
    cows = [(arrivals[i], inspections[i]) for i in range(n)]
    cows.sort()

    current_time = 0

    for arrival, inspection in cows:
        if current_time < arrival:
            current_time = arrival
        current_time += inspection

    return current_time

n = int(input())
arrivals = []
inspections = []

for _ in range(n):
    arrival, inspection = map(int, input().split())
    arrivals.append(arrival)
    inspections.append(inspection)

result = calc_min_time(n, arrivals, inspections)
print(result)