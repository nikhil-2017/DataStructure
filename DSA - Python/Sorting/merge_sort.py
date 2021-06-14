# Merge sort
# O(nlog(n)) time | O(nlog(n)) space
def merge_sort(array):
    if len(array) == 1:
        return array

    middleIdX = len(array) // 2
    leftHalf = array[:middleIdX]
    rightHalf = array[middleIdX:]
    return merge_sorted_arrays(merge_sort(leftHalf), merge_sort(rightHalf))


def merge_sorted_arrays(leftHalf, rightHalf):
    sorted_array = [None] * (len(leftHalf) + len(rightHalf))
    k = i = j = 0
    while i < len(leftHalf) and j < len(rightHalf):
        if leftHalf[i] <= rightHalf[j]:
            sorted_array[k] = leftHalf[i]
            i += 1
        else:
            sorted_array[k] = rightHalf[j]
            j += 1
        k += 1

    while i < len(leftHalf):
        sorted_array[k] = leftHalf[i]
        i += 1
        k += 1

    while j < len(rightHalf):
        sorted_array[k] = rightHalf[j]
        j += 1
        k += 1

    return sorted_array


array = list(map(int, input().split(' ')))
print(merge_sort(array))