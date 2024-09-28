def find_number(n):
    pass

while True:
    try:
        n = int(input())
        print(find_number(n))
    except EOFError:
        break