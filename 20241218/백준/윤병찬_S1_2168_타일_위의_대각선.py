##
##
##

####
####
####
####


#####
#####
#####
#####
#####
#####

# 최대공약수 x 

def gcd(x, y):
    if y > x:
        x, y = y, x
    while True:
        if y == 0:
            break
        x, y = y, x % y
    return x

x, y = map(int, input().split(' '))

print(x + y - gcd(x, y))