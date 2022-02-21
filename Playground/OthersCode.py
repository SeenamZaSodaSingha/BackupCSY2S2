def position_number(n):
    posnum = [1, 2]

    #base case
    if(n == 1): return posnum

    oddJump, evenJump = 3, 2

    while(True):
        # check if item in list meet the conditions -> list[-2] <= n < list[-1] in range 100 
        if((posnum[-2] <= n and posnum[-1] > n) or posnum[-1] >= 100): break
        # add new item into list 
        # if confuse about below syntax it's call Ternary operator
        # the terms is -> [do if meet cond] if [condition] else [do if not meet cond]
        else: posnum.append(posnum[-1] + oddJump if len(posnum) % 2 == 0 else posnum[-1] + evenJump); 
        
        # expand odd and event jump sequence
        if (len(posnum) % 2 != 0): oddJump += 2
        else: evenJump += 1
    
    return posnum
    
# driver code
n = int(input())
positionNum = []
positionNum = position_number(n)
print(positionNum)