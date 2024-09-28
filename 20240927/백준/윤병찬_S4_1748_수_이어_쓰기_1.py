N = int(input())

length = 0
digit = 1
start = 1 
while start <= N:
    end = start * 10 - 1
    if end > N:
        end = N
    length += (end - start + 1) * digit
    digit += 1
    start *= 10

print(length)
