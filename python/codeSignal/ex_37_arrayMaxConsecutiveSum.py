# https://app.codesignal.com/arcade/intro/level-8/Rqvw3daffNE7sT7d5


def arrayMaxConsecutiveSum(inputArray, k):
    sum_temp = sum(inputArray[0:k])
    max_sum = sum_temp
    for index in range(len(inputArray)):
        if index != 0 and (index + k) <= len(inputArray):
            # subtract the number before and plus the number increase, don't need to calculate all again
            sum_temp = sum_temp - inputArray[index - 1] + inputArray[index + k - 1]
            max_sum = max(sum_temp, max_sum)
    return max_sum


print(arrayMaxConsecutiveSum([3, 2, 1, 1], 1))
