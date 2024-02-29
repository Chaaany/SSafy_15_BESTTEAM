from itertools import permutations

def check(question, guess):
    strike, ball = 0, 0
    for i in range(3):
        if question[i] == guess[i]:
            strike += 1
        elif question[i] in guess:
            ball += 1
    return strike, ball


# 입력
n = int(input())
questions = [input().split() for _ in range(n)]

numbers = [str(i) for i in range(1, 10)]
possible_numbers = [''.join(p) for p in permutations(numbers, 3)]

count = 0
for numbers in possible_numbers:
    check_decision = True
    for question, strike, ball in questions:
        s, b = check(question, numbers)
        if not (s == int(strike) and b == int(ball)):
            check_decision = False
            break
    if check_decision:
        count += 1

print(count)

