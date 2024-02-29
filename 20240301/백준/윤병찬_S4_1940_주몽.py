def count_comb(target, item):
    count = 0
    item.sort()
    l, r = 0, len(item) - 1

    while l < r:
        total = item[l] + item[r]

        if total == target:
            count += 1
            l += 1
            r -= 1
        elif total < target:
            l += 1
        else:
            r -= 1

    return count


N = int(input())
M = int(input())
item = list(map(int, input().split()))

result = count_comb(M, item)
print(result)
