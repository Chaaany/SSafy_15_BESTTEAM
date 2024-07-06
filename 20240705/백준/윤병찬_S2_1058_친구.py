def count_two_friends(n, friends):
    max_friends = 0

    for i in range(n):
        friend_set = set()

        for j in range(n):
            if friends[i][j] == 'Y':
                friend_set.add(j)
                for k in range(n):
                    if friends[j][k] == 'Y':
                        friend_set.add(k)
        
        friend_set.discard(i)
        max_friends = max(max_friends, len(friend_set))
    
    return max_friends

n = int(input())
friends = [input().strip() for _ in range(n)]

print(count_two_friends(n, friends))