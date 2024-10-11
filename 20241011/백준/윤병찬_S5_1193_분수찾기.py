# X -> 대각선
# 대각선 홀수 - 분자가 감소하고 분모가 증가
# 대각선 짝수 -  분자가 증가하고 분모가 감소


X = int(input())  

line = 1
while X > line:
    X -= line
    line += 1

if line % 2 == 0:
    numerator = X
    denominator = line - X + 1
else:
    numerator = line - X + 1
    denominator = X

print(f"{numerator}/{denominator}")

