import sys
from itertools import permutations

input = sys.stdin.readline

n = int(input())
k = int(input())

numbers = [0] * n
for i in range(n):
    numbers[i] = int(input())

tmp = permutations(numbers, k)
tmp = list(set(tmp))
answer = set()
for num_list in tmp:
    result_string = ''.join(str(num) for num in num_list)
    answer.add(result_string)
print(len(answer))