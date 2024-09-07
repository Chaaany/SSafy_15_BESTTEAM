
N1, N2 = map(int, input().split())
N1_seq = input()
N2_seq = input()
snapshot_seq = int(input())
N1_seq = N1_seq[::-1]
seq = N1_seq + N2_seq
total_len = N1 + N2
for _ in range(snapshot_seq):
    chk = [False] * total_len
    for i in range(total_len):
        if (seq[i] in N1_seq and i < total_len - 1 and not chk[i]) and (seq[i + 1] in N2_seq and not chk[i + 1]): # 교차되는 문자열
            chk[i] = True
            chk[i + 1] = True
            seq = seq[:i] + seq[i+1] + seq[i] + seq[i+2:]

print(seq)