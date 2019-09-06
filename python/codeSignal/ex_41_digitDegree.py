# https://app.codesignal.com/arcade/intro/level-9/hoLtYWbjdrD2PF6yo


def isMoreThanTwoDigits(n):
    return len(str(n)) > 1


def sumOfAllDigits(n):
    result = 0
    for number in str(n):
        result += int(number)
    return result


def digitDegree(n):
    acc = 0
    while isMoreThanTwoDigits(n):
        acc += 1
        n = sumOfAllDigits(n)
    return acc


print(digitDegree(91))
