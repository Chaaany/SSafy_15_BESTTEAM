n = int(input())

columns = []
result = 0
for i in range(n) :
    a,b = map(int,input().split())
    columns.append([a,b])
columns.sort()

i = 0
for l in columns :
    if l[1] >result :
        result = l[1]
        max_height_number = i
    i += 1

height = columns[0][1]

for i in range(max_height_number) :
    if height < columns[i+1][1] :
        result += height * (columns[i+1][0]-columns[i][0])
        height = columns[i+1][1]
    else :
        result += height * (columns[i+1][0] - columns[i][0])

height = columns[-1][1]

for i in range(n-1, max_height_number, -1) :
    if height < columns[i-1][1] :
        result += height * (columns[i][0]-columns[i-1][0])
        height = columns[i-1][1]
    else :
        result += height * (columns[i][0] - columns[i-1][0])

print(result)