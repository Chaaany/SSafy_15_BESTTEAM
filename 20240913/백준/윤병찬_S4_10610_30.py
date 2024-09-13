N = input()

is_zero_included = N.find("0")
total = 0
if is_zero_included == -1:
    print(is_zero_included)
else:
    for number in N:
        total += int(number)
    if total % 3 == 0:
        zero_index = N.index("0")
        N = N[:zero_index] + N[zero_index + 1:] + "0"
        print(N)
    else:
        print(-1)



