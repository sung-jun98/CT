def solution(n):
    numOfOne = 0
    answer = 0
    numOfOne = get_numOfOne(n)
    n += 1
    #print(numOfOne)
    while True:
        if get_numOfOne(n) == numOfOne:
            answer = n
            #print(answer)
            break
        else:
            n += 1
    
    
    return answer

def get_numOfOne(n):
    tmp = n
    num_of_one = 0
    while True:
        other = tmp % 2
        tmp = tmp // 2
        if other == 1:
            num_of_one += 1
            #print(tmp)
        if tmp <= 1:
            num_of_one += 1
            #print(tmp)
            break
    #print(num_of_one)
    return num_of_one