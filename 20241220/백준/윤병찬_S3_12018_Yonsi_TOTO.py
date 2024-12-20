n, m = map(int, input().rstrip().split(" "))
mileage_list = []

for _ in range(n):
    P, L = map(int, input().rstrip().split(" "))
    student_list = list(map(int, input().split(" ")))
    if P >= L:
        student_list.sort(reverse=True)
        mileage_list.append(student_list[L - 1])
    else:
        mileage_list.append(1)    
        
        
        
mileage_list.sort()
subtotal_mileage = 0
answer = 0
for i in range(n):
    if subtotal_mileage + mileage_list[i] <= m:
        subtotal_mileage += mileage_list[i]
        answer += 1
    else:
        break
    
print(answer)
    