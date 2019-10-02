# https://app.codesignal.com/arcade/intro/level-9/AACpNbZANCkhHWNs3


def longestDigitsPrefix(inputString):
    result = ''
    for char in inputString:
        if char.isdigit():
            result = result + char
        else:
            return result
    return result


print(longestDigitsPrefix('0123456789'))
