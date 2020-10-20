# solution - written by Nikhil Gaikwad and referred by AlgoExpert.

# where n: number of prices len(prices)
# k: number of rows/t i.e. k

# O(nk) time | O(nk) space
# def maxProfitWithKTransaction(prices, k):
#     if not len(prices):
#         return 0
    
#     profits = [[0 for d in prices] t in range(k+1)]

#     for t in range(1, k+1):
#         maxThusFar = float("-inf")
#         for d in range(1, len(prices)):
#             maxThusFar = max(maxThusFar, profits[t - 1][d - 1] - prices[d - 1])
#             profits[t][d] = max(profits[t][d - 1], maxThusFar + prices[d])
    
#     return profits[-1][-1]


# O(nk) time | O(n) space - optimized solution
def maxProfitWithKTransaction(prices, k):
    
    if not len(prices):
        return 0

    evenProfits = [0 for d in prices]
    oddProfits = [0 for d in prices]

    for t in range(1, k+1):
        maxThusFar = float("-inf")
        if t%2 == 1:
            currentProfits = oddProfits
            previousProfits = evenProfits
        else:
            currentProfits = evenProfits
            previousProfits = oddProfits
        
        for d in range(1, len(prices)):
            maxThusFar = max(maxThusFar, previousProfits[d - 1] - prices[d - 1])
            currentProfits[d] = max(currentProfits[d - 1], maxThusFar + prices[d])
    
    return evenProfits[-1] if (k % 2 == 0) else oddProfits[-1]



prices = list(map(int, input().split(" ")))
k = int(input())

result = maxProfitWithKTransaction(prices, k)
print("maxProfit: {}".format(result))

# TestCase-1:
# 5 11 3 50 60 90
# 2
# Output: 
# maxProfit: 93