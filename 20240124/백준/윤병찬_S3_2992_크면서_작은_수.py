# 6!

def permutations(seq, current_number):
	global origin_number, answer, check
	if len(current_number) == len(origin_number):
		if int(current_number) > int(origin_number):
			answer = min(int(answer), int(current_number))
		return

	for i in range(len(origin_number)):
		if check[i]: continue
		new_number = current_number + origin_number[i]
		check[i] = True
		permutations(i, new_number)
		check[i] = False

origin_number = input()
check = [False] * len(origin_number)
answer = 1000000
permutations(0, "")

if answer == 1000000:
	print(0)
else:
	print(answer)
