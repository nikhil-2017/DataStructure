# Merge sort
# O(nlog(n)) time | O(n) space
def mergeSort(array):
    if len(array) <= 1:
        return array

    auxArray = array[:]
    mergeSortHelper(array, 0, len(array)-1, auxArray)
    return array


def mergeSortHelper(mainArray, startIdX, endIdX, auxArray):
    if startIdX == endIdX:
        return
    middleIdX = (startIdX + endIdX) // 2
    mergeSortHelper(auxArray, startIdX, middleIdX, mainArray)
    mergeSortHelper(auxArray, middleIdX+1, endIdX, mainArray)
    doMerge(mainArray, startIdX, middleIdX, endIdX, auxArray)


def doMerge(mainArray, startIdX, middleIdX, endIdX, auxArray):
    k = startIdX
    i = startIdX
    j = middleIdX + 1

    while i <= middleIdX and j <= endIdX:
        if auxArray[i] <= auxArray[j]:
            mainArray[k] = auxArray[i]
            i += 1
        else:
            mainArray[k] = auxArray[j]
            j += 1
        k += 1

    while i <= middleIdX:
        mainArray[k] = auxArray[i]
        i += 1
        k += 1

    while j <= endIdX:
        mainArray[k] = auxArray[j]
        j += 1
        k += 1


array = list(map(int, input().split(' ')))
print(mergeSort(array))