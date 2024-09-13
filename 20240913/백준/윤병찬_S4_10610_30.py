N = str(input())

if not "0" in N:
    print("-1")
    exit(0)
list_N = list(N)
list_N.sort(reverse=True)
total = 0
for number in list_N:
    total += int(number)
if total % 3 == 0:
    print("".join(list_N))
else:
    print("-1")