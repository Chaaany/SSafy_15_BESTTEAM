K = int(input())
binary_representation = bin(K)[2:]
highest_place = len(binary_representation)

highest_position = len(binary_representation) - 1
lowest_position = binary_representation.rfind('1')
split_count = highest_position - lowest_position + 1

chocolate_size = 2 ** highest_place if split_count != 1 else 2 ** (highest_place - 1)

print(chocolate_size, split_count)