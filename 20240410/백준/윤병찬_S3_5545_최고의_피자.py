# 정렬 후 높은 것부터 넣다가 전보다 낮아지면 끝

import math

topping_count = int(input().strip())

dow_price, topping_price = map(int, input().split())

dow_calories = int(input().strip())
topping_calories = []
for _ in range(topping_count):
    topping_calories.append(int(input().strip()))

topping_calories.sort(reverse=True)
total_calories = dow_calories
total_price = dow_price
total_calories_per_price = total_calories / total_price
for topping_seq in range(topping_count):
    next_calories = total_calories + topping_calories[topping_seq]
    next_price = total_price + topping_price
    next_calories_per_price = next_calories / next_price
    if total_calories_per_price < next_calories_per_price:
        total_calories_per_price = next_calories_per_price
        total_calories = next_calories
        total_price = next_price 
    else:
        break

print(math.floor(total_calories_per_price))