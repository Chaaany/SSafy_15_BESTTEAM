N = int(input())
answer = 0
for _ in range(N):
    word = input()
    alphabet_stack = []
    for i in range(len(word)):
        if alphabet_stack: # stack에 원소 존재
            if alphabet_stack[-1] == word[i]:
                alphabet_stack.pop()
            else:
                alphabet_stack.append(word[i])
        else:
            alphabet_stack.append(word[i])
    if not alphabet_stack:
        answer += 1

print(answer)
