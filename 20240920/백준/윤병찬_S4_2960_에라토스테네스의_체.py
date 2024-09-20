N, K = map(int, input().split())

chk = [False for _ in range(N + 1)]
count = 0
for i in range(1, N + 1):
    if i == 1: continue
    if chk[i]:
        continue
    else:
        cur = i
        while cur <= N:
            if not chk[cur]:
                count += 1
                chk[cur] = True
                if count == K:
                    print(cur)
                    exit(0)
            cur += i
