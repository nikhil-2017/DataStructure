def knapsackProblem(items, capacity):
    knapsackValues = [[0 for x in range(0, capacity+1)] for y in range(0, len(items)+1)]

    for i in range(1, len(items)+1):
        currentWeight = items[i-1][1]
        currentValue = items[i-1][0]

        for c in range(0, capacity+1):
            if currentWeight > c:
                knapsackValues[i][c] = knapsackValues[i-1][c]
            else:
                knapsackValues[i][c] = max(knapsackValues[i-1][c], knapsackValues[i-1][c - currentWeight] + currentValue)
    
    return [knapsackValues[-1][-1], getKnapSackItems(knapsackValues, items)]

def getKnapSackItems(knapsackValues, items):
    sequence = []
    i = len(knapsackValues) - 1
    c = len(knapsackValues[i]) - 1

    while i > 0:
        if knapsackValues[i][c] == knapsackValues[i-1][c]:
            i-=1
        else:
            sequence.append(i-1)
            c -= items[i-1][1]
            i -= 1
        
        if c == 0:
            break

    return list(reversed(sequence))


items = [[1,2],[4,3],[5,6],[6,7]]
capacity = 10

result = knapsackProblem(items, capacity)
print("filled Capacity: {}".format(result[0]))
print([items[i] for i in result[1]])