print('In this program, we will let you know how many sheets of different values of money you have.')
amountMoney = int(input('Enter your money you have: '))
values = [50000, 20000, 10000, 5000, 2000, 1000]
sheets = [0, 0, 0, 0, 0, 0]
best = []
for i in range(len(values)):
    temp = amountMoney
    if (amountMoney >= values[i]):
        for j in range(i, len(values)):
            value = values[j]
            if (temp >= value):
                sheet = temp//value
                temp = temp%value
                sheets[j] = sheet
        print('Your sheets you have:', sheets)
        if (len(best) == 0):
            best = sheets
        sheets = [0, 0, 0, 0, 0, 0]
print('The best decision is:', best)

