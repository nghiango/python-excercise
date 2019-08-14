
def swap(str, currentIndex, changedInex):
    str[currentIndex], str[changedInex] = str[changedInex], str[currentIndex]

def permute(str, startIndex, endIndex):
    if startIndex == endIndex:
        print(str)
    else:
        for i in range(startIndex, endIndex + 1):
            swap(str, i, startIndex)
            permute(str, startIndex + 1, endIndex)
            swap(str, i, startIndex)

def printResult(content):
    print(content)