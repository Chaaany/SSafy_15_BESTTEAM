import sys

def calc(digit):
	global N
	global N_list
	global answer_set
	global number_list
	if digit == N:
		by_total = eval('+'.join(map(str,N_list)))
		answer_set.add(by_total)
		return
	for i in range(len(number_list)):
		N_list[digit] = number_list[i]
		calc(digit+1)


number_list = [1, 5, 10, 50]        # print(by_total)
input = sys.stdin.readline
N = int(input())
answer_set = set()
N_list = [0] * N

calc(0)


print(len(answer_set))
    