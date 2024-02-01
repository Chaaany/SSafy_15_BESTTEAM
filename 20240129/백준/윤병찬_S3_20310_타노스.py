S = input()

#s의 0의 갯수와 1의 갯수를 줄여보자
zero_count = S.count("0")
one_count = S.count("1")

for _ in range(zero_count//2):
    S = S[:S.rindex("0")] + S[S.rindex("0") + 1:]

for _ in range(one_count//2):
    S = S[:S.index("1")] + S[S.index("1") + 1:]

print(S)