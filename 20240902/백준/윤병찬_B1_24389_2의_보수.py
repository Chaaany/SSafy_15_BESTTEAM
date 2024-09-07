N = int(input())
bit_32 = 32
int_to_32bit = N & (( 1 << bit_32 ) - 1)
complement_of_two = (~N + 1) & (( 1 << bit_32 ) - 1)
count_diff = bin(int_to_32bit ^ complement_of_two).count('1')
print(count_diff)
