def solution(n):
    answer = 0
    
    
    for i in range(n, 0, -1):
        if sum(n, i) == True:
            answer += 1
    return answer

def sum(quest, n):
    tmp = 0
    answer = False
    for i in range(n, 0, -1):
        tmp += i
        if tmp == quest:
            answer = True
            return answer
        elif tmp > quest:
            return False
            
    
    return answer