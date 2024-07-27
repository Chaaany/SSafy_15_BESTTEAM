n=int(input())
prices=[]
for i in range(n):
  prices.append(int(input()))
prices.sort(reverse=True)

result=0
for i in range(2,len(prices),3):
  result+=prices[i]

print(sum(prices)-result)