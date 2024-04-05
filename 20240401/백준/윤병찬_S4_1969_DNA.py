# N개의 길이 M인 DNA s1, s2, ..., sn가 주어져 있을 때
# Hamming Distance의 합이 가장 작은 DNA s를 구하는 것

# N개의 단어에 대해 M개의 각 단어에 대해 순회함
# A, C, G, T

# 각 단어의 0번 = A, 1번 = C, 2번 = G, 3번 = T
import sys

N, M = map(int, sys.stdin.readline().split())

dna = ["A", "C", "G", "T"]
dna_list = [""] * N
count_hamming_distance = [[0,0,0,0] for i in range(M)]
for i in range(N):
    dna_list[i] = sys.stdin.readline().strip()
    for j in range(M):
        dna_length = len(dna)
        for k in range(dna_length):
            if dna_list[i][j] == dna[k]:
                count_hamming_distance[j][k] += 1
                continue
        
answer = ["A"] * M    
answer_count = 0    
for i in range(M):
    max_index = 0
    max_count = count_hamming_distance[i][max_index]
    for j in range(4):
        if count_hamming_distance[i][max_index] < count_hamming_distance[i][j]:
            answer[i] = dna[j]
            max_index = j
            max_count = count_hamming_distance[i][max_index]
    answer_count += N - max_count
print(''.join(str(x) for x in answer))
print(answer_count)