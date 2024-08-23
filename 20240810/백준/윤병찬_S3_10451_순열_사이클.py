# dictionary로 값 만들기
count = 0

def check_permutation_cycle(dict_value, current_node, visited):
    if visited[current_node]:
        return 1
    
    visited[current_node] = True
    return check_permutation_cycle(dict_value, dict_value[current_node], visited)
    

T = int(input())
for _ in range(T):
    N = int(input())
    count = 0
    dict_value = {}
    keys = list(map(int, input().split()))
    visited = [False] * (N + 1)
    for value in range(1, N + 1):
        dict_value[value] = keys[value - 1]
    for current_node in range(1, N + 1):
        if not visited[current_node]:
            count += check_permutation_cycle(dict_value, current_node, visited)
            
    print(count)