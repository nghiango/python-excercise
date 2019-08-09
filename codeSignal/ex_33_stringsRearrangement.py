# https://app.codesignal.com/arcade/intro/level-7/PTWhv2oWqd6p4AHB9
def stringsRearrangement(inputArray: list):
    hasAnySatisfy = False
    for i in range(len(inputArray)):
        for j in range(len(inputArray)):
            tempList = inputArray.copy()
            tempList.pop(i)
            tempList.insert(j, inputArray[i])
            hasAnySatisfy = isAllElementsDifferByOneCharacter(tempList)
            print(tempList)
            if hasAnySatisfy:
                return True
    return False

def isDifferentByOneCharacter(string, otherString):
    acc = 0
    for i in range(len(string)):
        if string[i] != otherString[i]:
            acc += 1
    if acc == 1:
        return True
    return False

def isAllElementsDifferByOneCharacter(arr: list):
    isSatisfyAll = True
    for i in range(len(arr)):
        if (i+1) < len(arr):
            isSatisfyAll = isDifferentByOneCharacter(arr[i], arr[i+1])
            if isSatisfyAll == False:
                return False
    return True

def main():
    stringarr = ["abc", 
 "bef", 
 "bcc", 
 "bec", 
 "bbc", 
 "bdc"]
    print(stringsRearrangement(stringarr))

main()