# A  1 0
# BA 1 1
# BAB 1 2
# BABBA 2 3
# BABBABAB 3 5
# BABBABABBABBA 5 8

# A : 1 1 1 2 3 5 8 13
# B : 0 1 2 3 5 9 13 22
def fibonacci(n):
	global fibonacci_list
	if fibonacci_list[n] != 0:
		return fibonacci_list[n]
	if n == 1:
		return 1
	elif n == 0:
		return 0
	else:
		fibonacci_list[n] = fibonacci(n-1) + fibonacci(n-2)
		return fibonacci_list[n]
fibonacci_list = [0, 0, 1] + [0] * 43
K = int(input())

print(fibonacci(K-1), fibonacci(K))
