# O(n^2) time | O(n) space
# def minNumberOfJumps(array):
#     jumps = [float("inf") for x in array]
#     jumps[0] = 0
#     for i in range(1, len(array)):
#         for j in range(0, i):
#             if array[j] + j >= i:
#                 jumps[i] = min(jumps[i], jumps[j] + 1)
    
#     return jumps[-1]

# O(n) time | O(1) space
def minNumberOfJumps(array):
    if len(array) == 1:
        return 0
    
    jumps = 0
    maxReach = array[0]
    steps = array[0]

    for i in range(1, len(array)-1):
        maxReach = max(maxReach, array[i] + i)
        steps -= 1
        if steps == 0:
            jumps += 1
            steps = maxReach - i

    return jumps + 1

array = list(map(int, input().split(" ")))
print(minNumberOfJumps(array))