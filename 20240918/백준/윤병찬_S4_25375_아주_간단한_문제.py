# gcd(x,y) = a
# x + y = b = ar1 + ar2 = a(r1 + r2)
# x = ar1, y = ar2 = b - x = b - ar1 = a(r1 + r2) - ar1
# r1, r2는 서로소
# a(r1 + r2) = b => r1 + r2 = b/a -> r1 + r2 >= 2(자연수의 합), b/a = b는 a의 배수
t = int(input())  # 테스트 케이스 수 입력

for _ in range(t):
    a, b = map(int, input().split())
    
    if b % a == 0 and b // a >= 2:
        print(1)
    else:
        print(0)
