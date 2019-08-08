# https://app.codesignal.com/arcade/intro/level-7/PTWhv2oWqd6p4AHB9
def stringsRearrangement(inputArray):
    print("")


def isDifferentByOneCharacter(string, otherString):
    acc = 0
    for i in range(len(string)):
        if string[i] != otherString[i]:
            acc += 1
        if acc > 1:
            return False
    return True

print(isDifferentByOneCharacter("aaa", "aac"))
print(isDifferentByOneCharacter("aaa", "cac"))