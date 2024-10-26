x, y = map(int, input().split())

z = (y * 100) // x

if z >= 99:
    print(-1)
else:
    left, right = 1, 1000000000
    answer = -1

    while left <= right:
        mid = (left + right) // 2
        new_z = ((y + mid) * 100) // (x + mid)

        if new_z > z:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1

    print(answer)