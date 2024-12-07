import sys

number = sys.stdin.readline().rstrip()
n = 0
index = 0
while True:
    n += 1
    
    for s in str(n):
        if number[index] == s:
            index += 1
            if index >= len(number):
                print(n)
                exit()