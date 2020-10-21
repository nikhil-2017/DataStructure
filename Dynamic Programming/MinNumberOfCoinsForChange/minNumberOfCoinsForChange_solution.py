# O(nd) time | O(n) space
def minNumberOfCoinsForChange(n, denoms):
    numOfCoins = [float("inf") for amount in range(n+1)]
    numOfCoins[0] = 0
    for denom in denoms:
        for amount in range(len(numOfCoins)):
            if denom <= amount:
                numOfCoins[amount] = min(numOfCoins[amount], 1 + numOfCoins[amount - denom])

    return numOfCoins[n] if (numOfCoins[n] != float("inf")) else -1


def getResult(minCoinsCount):
    if (minCoinsCount == -1):
        print("Not valid denoms to make n.")
    else:
        print("Min Numbers of coins: {}".format(minCoinsCount))


n = int(input())
denoms = list(map(int, input().split(" ")))

getResult(minNumberOfCoinsForChange(n, denoms))

