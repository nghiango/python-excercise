# https://app.codesignal.com/arcade/intro/level-7/ZFnQkq9RmMiyE6qtq
import sys
def absoluteValuesSumMinimization(a):
    correctValue = sys.maxsize
    minSum = sys.maxsize
    for value in a:
        sumAbs = sumAbsOfOneElement(a, value)
        if minSum > sumAbs:
            minSum = sumAbs
            correctValue = value
        elif minSum == sumAbs and correctValue > value:
            correctValue = value
    return correctValue
    # return a[(len(a)-1)//2] This is the advance version


def absBetweenTwoNumber(first, second):
    return abs(first - second)


def sumAbsOfOneElement(array, element):
    acc = 0
    for value in array:
        acc += absBetweenTwoNumber(value, element)
    return acc


a = [2, 4, 7, 8, 9]
print(absoluteValuesSumMinimization(a))