# B -> A
def calc(number, target_number, calc_count):
    if number == 0:
        return -1 
    validate_calc1_number = (number - 1) % 10
    validate_calc2_number = number % 2
    calc1_number = (number - 1) // 10
    calc2_number = number // 2

    if (validate_calc1_number == 0 and target_number == calc1_number) or (validate_calc2_number == 0 and target_number == calc2_number):
        return calc_count + 1

    if validate_calc1_number == 0:
        return calc(calc1_number, target_number, calc_count + 1)
    elif validate_calc2_number == 0:
        return calc(calc2_number, target_number, calc_count + 1)
    else:
        return -1
A, B = map(int, input().split(' '))

answer = calc(B, A, 1)

print(answer)
    


