# 1. 무게 정렬
# 2. 처음, 끝부터 차근차근 투포인터로 좁히기
# 3. 최댓값 보다 작거나 같으면 둘 다 좁히고 아니면 오른쪽꺼 인덱스 - 1
# 3. 처음과 끝 인덱스가 교차하면 종료

N, K = map(int, input().split())

weight_list = list(map(int, input().split()))

weight_list.sort()
l, r = 0, len(weight_list) - 1
answer = 0
while l < r:
    tmp_weight_total = weight_list[l] + weight_list[r]
    if tmp_weight_total <= K:
        answer += 1
        l += 1
        r -= 1
    else:
        r -= 1

print(answer)