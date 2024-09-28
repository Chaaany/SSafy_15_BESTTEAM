def find_number(n):
    num = 1
    count = 1

    while num % n != 0:
        num = (num * 10 + 1) % n
        count += 1
    return count

while True:
    try:
        n = int(input())
        print(find_number(n))
    except EOFError:
        break