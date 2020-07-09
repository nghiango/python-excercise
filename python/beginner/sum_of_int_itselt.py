x = int(input('Enter integer: '))
sumOfAll = 0
while x != 0:
    sumOfAll += x%10
    x = x//10
print(sumOfAll)
