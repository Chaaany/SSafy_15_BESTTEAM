import sys

def cantor_set(n):
    if n == 0:
        return '-'
    prev = cantor_set(n - 1)
    return prev + ' ' * (3 ** (n - 1)) + prev

input_data = sys.stdin.read().split()

for n in input_data:
    print(cantor_set(int(n)))
