def solution(n):
    answer = []
    array = [[0]*n for i in range(n)]
    tri = [[1,0],[0,1],[-1,-1]]
    x = y = d = cnt = 0
    maxn = (n * n) / 2 + (n/2)
    while True:
        if(array[x][y] != 0): break
        cnt += 1
        array[x][y] = cnt
        if(cnt == maxn): break
        nx = x + tri[d][0]
        ny = y + tri[d][1]
        if(nx >= n or ny >= n or nx < 0 or ny < 0 or array[nx][ny] != 0):
            d = (d+1) % 3
        x = x + tri[d][0]
        y = y + tri[d][1]
    
    for i in range(0,n):
        for j in range(0,i+1):
            answer.append(array[i][j])
    return answer
