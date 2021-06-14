
# Quick Sort
# O(n^2) worst time | O(n log(n)) best/avg time | O(log(n)) space
def quick_sort(array):
    quick_sort_helper(array, 0, len(array)-1)
    return array


def quick_sort_helper(array, startIdX, endIdX):
    if startIdX >= endIdX:
        return
    pivotIdX = startIdX
    leftIdX = startIdX+1
    rightIdX = endIdX
    while rightIdX >= leftIdX:
        if array[leftIdX] > array[pivotIdX] and array[rightIdX] < array[pivotIdX]:
            swap(leftIdX, rightIdX, array)
        if array[leftIdX] <= array[pivotIdX]:
            leftIdX+=1
        if array[rightIdX] >= array[pivotIdX]:
            rightIdX-=1
    swap(pivotIdX, rightIdX, array)
    left_subarray_is_smaller = rightIdX - 1 - startIdX < endIdX - (rightIdX + 1)
    if left_subarray_is_smaller:
        quick_sort_helper(array, startIdX, rightIdX-1)
        quick_sort_helper(array, rightIdX+1, endIdX)
    else:
        quick_sort_helper(array, rightIdX+1, endIdX)
        quick_sort_helper(array, startIdX, rightIdX-1)


def swap(i, j, array):
    array[i], array[j] = array[j], array[i]


arr = list(map(int, input().split(' ')))
print(quick_sort(arr))
