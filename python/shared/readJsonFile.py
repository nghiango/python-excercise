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


def buildNestedNode(keyArr, newDictionary, value, index):
    if index == (len(keyArr) - 1):
        newDictionary[keyArr[index]] = value
        return
    if keyArr[index] in newDictionary:
        pass
    else:
        newDictionary[keyArr[index]] = {}
    buildNestedNode(keyArr, newDictionary[keyArr[index]], value, index + 1)


def buildJson(dic):
    newDictionary = {}
    for key in dic:
        keyArr = str(key).split('.')
        buildNestedNode(keyArr, newDictionary, dic[key], 0)
    with open('D:/resource/data.json', 'w') as outfile:
        json.dump(newDictionary, outfile, indent=4)
    print(json.dumps(newDictionary, indent=4))


originalFileDataJson = json.loads(originalFileData)
prefix = ''
originalDic = {}
printAllKeyValue(originalFileDataJson, prefix, originalDic)

newFileDataJson = json.loads(newFileData)
prefix = ''
newDic = {}
printAllKeyValue(newFileDataJson, prefix, newDic)

buildJson(replaceValue(originalDic, newDic))
