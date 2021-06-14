# Selection sort
# O(n^2) time | O(1) space
def selection_sort(array):
    n = len(array)
    for k in range(0, n):
        pos = smallest(array, k, n)
        array[k], array[pos] = array[pos], array[k]
    return array


def smallest(array, k, n):
    pos = k
    small = array[k]
    for i in range(k+1, n):
        if array[i] < small:
            small = array[i]
            pos = i
    return pos


def selectionSort(array):
    currentIdx = 0
    while currentIdx < len(array) - 1:
        smallestIdx = currentIdx
        for i in range(currentIdx + 1, len(array)):
            if array[smallestIdx] > array[i]:
                smallestIdx = i
        swap(currentIdx, smallestIdx, array)
        currentIdx += 1
    return array


def swap(i, j, array):
    array[i], array[j] = array[j], array[i]


arr = list(map(int, input().split(' ')))
print(selection_sort(arr))
print(selectionSort(arr))
