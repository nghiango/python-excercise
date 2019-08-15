# https://app.codesignal.com/arcade/intro/level-7/PTWhv2oWqd6p4AHB9
from shared.utils import *


def stringsRearrangement(inputArray: list):
    canRearrangement = permute(inputArray, 0, len(inputArray) - 1, False)
    return canRearrangement


def isDifferentByOneCharacter(string, otherString):
    acc = 0
    for i in range(len(string)):
        if string[i] != otherString[i]:
            acc += 1
    if acc == 1:
        return True
    return False


def isAllElementsDifferByOneCharacter(arr: list):
    for i in range(len(arr)):
        if (i + 1) < len(arr):
            if not isDifferentByOneCharacter(arr[i], arr[i + 1]):
                return False
    return True


def permute(resource, startIndex, endIndex, canRearrangement):
    if canRearrangement:
        return canRearrangement
    if startIndex == endIndex:
        return isAllElementsDifferByOneCharacter(resource)
    else:
        for i in range(startIndex, endIndex + 1):
            swap(resource, i, startIndex)
            canRearrangement = permute(resource, startIndex + 1, endIndex, canRearrangement)
            swap(resource, i, startIndex)
            if canRearrangement:
                break
        return canRearrangement


def main():
    stringArr = ["ab",
                 "bb",
                 "aa"]
    print(stringsRearrangement(stringArr))


main()
