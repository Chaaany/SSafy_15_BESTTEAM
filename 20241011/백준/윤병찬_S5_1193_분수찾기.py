# 소수 빨리 찾기
def find_prime_number():
    global prime_number_list
    tmp_prime_number_list = []
    prime_number = 2

    while prime_number <= 10000000:
        if prime_number_list[prime_number]:
            tmp_prime_number_list.append(prime_number)
            for i in range(prime_number, 10000001, prime_number):
                prime_number_list[i] = False
        prime_number += 1
    return tmp_prime_number_list


prime_number_list = [True for _ in range(10000001)]
prime_number_list[0], prime_number_list[1] = False, False
prime_numbers = find_prime_number()

# print(prime_numbers)
A, B = map(int, input().split())

count = 0
for number in prime_numbers:
    square_number = 2
    while True:
        if A <= number ** square_number <= B:
            count += 1
            # print(f"number: {number}, square_number: {square_number}")
            
        if number ** square_number > B:
            break
        square_number += 1

print(count)
