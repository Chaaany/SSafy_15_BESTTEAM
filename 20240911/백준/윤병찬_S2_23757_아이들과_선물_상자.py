# 받은 선물 상자와 아이들의 희망하는 선물 수를 정렬함
# 아이들의 희망하는 선물 수는 리스트로 유지, 선물 상자의 선물 갯수는 stack 또는 queue로 변환
# stack 또는 queue에서 Pop/poll한 후 아이들의 희망대로 줄 수 있다면 아이들 popㄱㄱ 아니면 계속 반복
# 남은 아이들이 있다면 

import heapq

N, M = map(int, input().split())

present_list = list(map(int, input().split()))
hope_to_receive_present_list = list(map(int, input().split()))

present_list = [-p for p in present_list]
heapq.heapify(present_list)

answer = 0
for hope in hope_to_receive_present_list:
    answer = 0
    while len(present_list) != 0:
        largest_present = -heapq.heappop(present_list)
        if largest_present >= hope:
            remaining_present = largest_present - hope
            if remaining_present != 0:
                heapq.heappush(present_list, -remaining_present)
            answer = 1
            break

print(answer)