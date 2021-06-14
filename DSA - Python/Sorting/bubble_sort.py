
# Bubble sort
# complexity - O(n^2) time | O(1) space | O(n^2) best time
def bubble_sort(arr):
    for i in range(len(arr)):
        for j in range(0, len(arr)-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr


# complexity - O(n^2) time | O(1) space | O(n) best time
def bubble_sort_best(array):
    is_sorted = False
    counter = 0
    while not is_sorted:
        is_sorted = True
        for i in range(0, len(array)-1-counter):
            if array[i] > array[i+1]:
                swap(i, i+1, array)
                is_sorted = False
        counter += 1
    return array


def swap(i, j, array):
    array[i], array[j] = array[j], array[i]
    # swap in diff. languages
    # tmp = array[i]
    # array[i] = array[j]
    # array[j] = tmp


arr = list(map(int, input().split(' ')))
print(bubble_sort(arr))
print(bubble_sort_best(arr))