A, B = map(int, input().split())
C, D = map(int, input().split())

numerator = A * D + B * C
denominator = B * D

number = 2
while number <= min(numerator, denominator):
    if numerator % number == 0 and denominator % number == 0:
        numerator //= number
        denominator //= number
        continue
    else:
        number += 1
        
print(numerator, denominator)