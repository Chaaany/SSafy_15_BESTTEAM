import sys

input = sys.stdin.readline

n = int(input())
entrance_and_left_record = dict()

for i in range(n):
    name, act = input().split()
    if name in entrance_and_left_record and act == 'leave':
        entrance_and_left_record.pop(name)
    elif act == 'enter':
        entrance_and_left_record[name] = "enter"

result = list(entrance_and_left_record.keys())
result.sort(reverse=True)

for name in result:
    print(name)
