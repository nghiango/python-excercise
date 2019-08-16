# https://app.codesignal.com/arcade/intro/level-8/8N7p3MqzGQg5vFJfZ


def differentSymbolsNaive(s):
    char_set = set([])
    for char in s:
        char_set.add(char)
    # return len(set(s))
    return len(char_set)


print(differentSymbolsNaive('aaabc'))
