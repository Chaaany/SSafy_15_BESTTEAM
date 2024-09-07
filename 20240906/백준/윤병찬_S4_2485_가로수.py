def get_gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

N = int(input())
first_tree_seq, last_tree_seq = -1, -1
gcd = -1
for i in range(N):
    if i == 0:
        first_tree_seq = int(input())
        prev_seq = first_tree_seq
    elif i == 1:
        seq = int(input())
        gcd = seq - prev_seq
    else:
        seq = int(input())
        diff = seq - prev_seq
        gcd = get_gcd(gcd, diff)
        prev_seq = seq
        if i == N - 1:
            last_tree_seq = seq

print((last_tree_seq-first_tree_seq) // gcd - N + 1)

