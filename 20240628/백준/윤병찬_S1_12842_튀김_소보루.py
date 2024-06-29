def find_last_person(n, s, m, soboru_times):
    n -= s
    time = 0
    idx = 0

    while n > 0:
        for i in range(m):
            if time % soboru_times[i] == 0:
                n -= 1
                idx = i + 1
                if n == 0:
                    break
        time += 1

    return idx

n, s = map(int, input().split())
m = int(input())
soboru_times = [int(input()) for _ in range(m)]

print(find_last_person(n, s, m, soboru_times))
