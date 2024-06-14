def solution(n):
    table = [0 for i in range(2001)]
    table[1] = 1
    table[2] = 2
    
    for i in range(3, n+1):
        table[i] = table[i-1] + table[i-2]
        
    answer = table[n] % 1234567
    #print(answer)
    return answer