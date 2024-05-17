

# Enter 받을 때마다 Enter 갯수 확인 총합에 list 길이 합 & list 초기화 생성, 없으면 +1 있으면 pass
# nicknames = []
# answer = 0
# for _ in range(N):
#     str = input()
#     if str == 'ENTER':
#         answer += len(nicknames)
#         nicknames = []
#         continue
#     if str in nicknames:
#         continue
#     else:
#         nicknames.append(str)
# answer += len(nicknames)
# print(answer)
    
# list를 map으로 변경
N = int(input())

nicknames = {}
answer = 0
for _ in range(N):
    nickname = input()
    if nickname == 'ENTER':
        answer += len(nicknames)
        nicknames = {}
        continue
    if nickname in nicknames:
        continue
    else:
        nicknames[nickname] = True

answer += len(nicknames)
print(answer)
