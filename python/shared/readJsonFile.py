import json

with open('../resource/test.json', 'r') as originalFile:
    originalFileData = originalFile.read()

with open('../resource/test-edit.json', 'r') as newFile:
    newFileData = newFile.read()


def remove_last_char(string: str):
    return string[:-1]


def printAllKeyValue(dataJson, prefix, jsonValueMap):
    temp = prefix
    for key in dataJson:
        try:
            if len(dataJson[key]) > 0:
                prefix += key + '.'
                printAllKeyValue(dataJson[key], prefix, jsonValueMap)
                prefix = temp
        except:
            prefix = remove_last_char(prefix)
            jsonValueMap[prefix] = dataJson
            break


def replaceValue(originalDic, newDic):
    for key in newDic:
        if len(originalDic[key]) > 0:
            originalDic[key] = newDic[key]
    return originalDic


def buildJson(dic):
    newDictionary = {}
    for key in dic:
        keyArr = str(key).split('.')
        previousKey = keyArr[0]
        for i in range(len(keyArr)):
            if i == (len(keyArr) - 1):
                newDictionary[i] = dic[key]
            else:
                if keyArr[i] in newDictionary:
                    print(keyArr[i])
                else:
                    newDictionary[keyArr[i]] = {keyArr[i+1]: ''}

    print(newDictionary)


originalFileDataJson = json.loads(originalFileData)
prefix = ''
originalDic = {}
printAllKeyValue(originalFileDataJson, prefix, originalDic)

newFileDataJson = json.loads(newFileData)
prefix = ''
newDic = {}
printAllKeyValue(newFileDataJson, prefix, newDic)

buildJson(replaceValue(originalDic, newDic))


