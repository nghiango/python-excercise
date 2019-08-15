# https://app.codesignal.com/arcade/intro/level-8/rRGGbTtwZe2mA8Wov


def firstDigit(inputString):
    for char in inputString:
        if char.isdigit():
            return char


print(firstDigit('var_1__Int'))
