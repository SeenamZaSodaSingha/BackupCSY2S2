# Returns the maximum value that
# can be put in a knapsack of
# capacity W

def knapSack(W, wt, val, n):

	# Base Case
	if n == 0 or W == 0:
		return 0

	# If weight of the nth item is
	# more than Knapsack of capacity W,
	# then this item cannot be included
	# in the optimal solution
	if (wt[n-1] > W):
		return knapSack(W, wt, val, n-1)

	# return the maximum of two cases:
	# (1) nth item included
	# (2) not included
	else:
		return max(
			val[n-1] + knapSack(
				W-wt[n-1], wt, val, n-1),
			knapSack(W, wt, val, n-1))


def ratioSortKnapSack(wt, val):
    ratio = []
    for i in range(len(wt)):
        ratio.append(val[i]/wt[i])

    max = 0.0
    for i in range(len(ratio)):
        max = ratio[i]
        idx = i
        for j  in range(i+1, len(ratio)):
            # print("j: ", j)
            if(max <= ratio[j]):
                max = ratio[j]
                idx = j
        #we done the j loop
        #we do swap
        #swap raio
        tmp = ratio[i]
        ratio[i] = max
        ratio[idx] = tmp

        #swap weight
        tmp = wt[i]
        wt[i] = wt[idx]
        wt[idx] = tmp

        #swap val
        tmp = val[i]
        val[i] = val[idx]
        val[idx] = tmp

# end of function knapSack


#Driver Code
#63050144 ->> 1 -> 63050144 <- 0
val = [16, 30, 50, 14, 40]
wt = [8, 13, 12, 15, 20]
W = int(input("Maximum weight: "))

ratioSortKnapSack(wt, val)
print ("Max val can take: ", knapSack(W, wt, val, 5))
"""
                           _
                        _ooOoo_
                       o8888888o
                       88" . "88
                       (| -_- |)
                       O\  =  /O
                    ____/`---'\____
                  .'  \\|     |//  `.
                 /  \\|||  :  |||//  \
                /  _||||| -:- |||||_  \
                |   | \\\  -  /'| |   |
                | \_|  `\`---'//  |_/ |
                \  .-\__ `-. -'__/-.  /
              ___`. .'  /--.--\  `. .'___
           ."" '<  `.___\_<|>_/___.' _> \"".
          | | :  `- \`. ;`. _/; .'/ /  .' ; |
          \  \ `-.   \_\_`. _.'_/_/  -' _.' /
===========`-.`___`-.__\ \___  /__.-'_.'_.-'================


          _.-/`)
         // / / )
      .=// / / / )
     //`/ / / / /
    // /     ` /
   ||         /
    \\       /
     ))    .'
    //    /
         /
"""