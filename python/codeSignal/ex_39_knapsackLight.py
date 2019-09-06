# https://app.codesignal.com/arcade/intro/level-9/r9azLYp2BDZPyzaG2


def knapsackLight(value1, weight1, value2, weight2, maxW):
    result = 0
    if (weight1 + weight2) <= maxW:
        return value1 + value2
    else:
        if weight1 <= maxW:
            result = value1
        if weight2 <= maxW:
            result = max(result, value2)
    return result


print(knapsackLight(11, 4, 9, 5, 6))
