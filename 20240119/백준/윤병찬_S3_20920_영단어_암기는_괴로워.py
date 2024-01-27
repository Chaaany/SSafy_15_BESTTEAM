import sys
from collections import Counter

def solve(words, k, m):
    # 길이가 m 이상이고 k 이상 등장한 단어들을 선별
    candidates = [word for word, count in Counter(words).items() if len(word) >= m]

    # 정렬 기준: 길이 내림차순, 사전순 오름차순
    candidates.sort(key=lambda x: (-len(x), x))

    return candidates

if __name__ == "__main__":
    input = sys.stdin.readline

    n, m = map(int, input().split())
    words = [input().strip() for _ in range(n)]

    result = solve(words, n, m)

    for word in result:
        print(word)
