import math
# 0 = X X X X X X 0
# 1 = O O O O O O 1  
# 2 = X O X O X O 1 0 
# 3 = X X O X X O 1 0 0 
# 4 = X X X O X X 1 0 0 1
# 5 = X X X X O X 1 0 0 1 0
# 6 = X X X X X O 1 0 0 1 0 0
#   = O X X O X O = 1 0 0 1 0 0
  
  
# 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24


N = int(input())

answer = 0


print(math.floor(math.sqrt(N)))