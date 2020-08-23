x = int(input('Enter integer: '))
sumOfAll = 0
y = x
while x != 0:
    sumOfAll += x%10
    x = x//10
    y = y/10

print(sumOfAll)
