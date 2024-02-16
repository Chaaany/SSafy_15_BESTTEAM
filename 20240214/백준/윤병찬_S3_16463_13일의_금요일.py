# 2019.01.01 화
# 2019.01.04 금
# 2019.01.11 금
# 2019.01.13
# 2019.01.18 금
# 2019.02.13
# 2019.03.13
# 365 - +1
# 366 - +2
# 윤년 X - 1 - 5, 2 - 3, 3 - 0, 4 - 3, 5 - 2, 6 - 3 -
# 윤년 O - 1 - 12, 2 - 31, 3 - 29, 4 - 31, 5 - 30, ... 12 - 30
#
# day_of_month = [31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30, 31]
# day_of_month = map(int, day_of_month)
# day_of_lunar_month = [31, 29, 31, 30, 31, 30, 31, 30, 31, 30, 31, 30, 31]

import datetime

def count_friday_13(year):
    count = 0
    for month in range(1, 13):
        if datetime.date(year, month, 13).weekday() == 4:
            count += 1
    return count


N = int(input())
count = 0
count_of_friday = [count_friday_13(year) for year in range(2019, 2019 + 400)]
# print(count_of_friday)
for year in range(2019, N + 1):
    count += count_of_friday[(year - 2019) % 400]
print(count)

# 2 2 1 1 2 2 1 3 1 1 2 2 1 2 1 2 2 1 3 1 1 3 2 1 3 1 2 2