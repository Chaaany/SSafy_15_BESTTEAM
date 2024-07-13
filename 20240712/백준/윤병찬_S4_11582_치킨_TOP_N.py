import sys


def merge_sort(arr, start, end, k):
    if end - start <= 1:
        return
    mid = (start + end) // 2
    merge_sort(arr, start, mid, k)
    merge_sort(arr, mid, end, k)
    if end - start <= len(arr) // k:
        temp = []
        i, j = start, mid
        while i < mid and j < end:
            if arr[i] < arr[j]:
                temp.append(arr[i])
                i += 1
            else:
                temp.append(arr[j])
                j += 1
        while i < mid:
            temp.append(arr[i])
            i += 1
        while j < end:
            temp.append(arr[j])
            j += 1
        for i in range(start, end):
            arr[i] = temp[i - start]

input = sys.stdin.read
input_data = input().split()

n = int(input_data[0])
arr = list(map(int, input_data[1:n+1]))
k = int(input_data[n+1])

merge_sort(arr, 0, n, k)

print(" ".join(map(str, arr)))

