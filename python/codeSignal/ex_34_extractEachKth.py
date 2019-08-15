# https://app.codesignal.com/arcade/intro/level-8/3AgqcKrxbwFhd3Z3R
from shared.utils import *


def extractEachKth(inputArray: list, k: int):
    # We use `del` keyword to remove
    # and `slicing` in python to get sub-list
    # before first colon is the start index
    # after first colon is the end index
    # after second colon is the increment
    del inputArray[k-1::k]
    return inputArray


print(extractEachKth([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3))
