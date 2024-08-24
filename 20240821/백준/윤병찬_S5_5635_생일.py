n = int(input())
student_info = []
for _ in range(n):
    student_info.append(list(input().split()))

student_info.sort(key=lambda x: (-int(x[3]), -int(x[2]), -int(x[1]), x[0]))

print(student_info[0][0] + '\n' + student_info[-1][0])