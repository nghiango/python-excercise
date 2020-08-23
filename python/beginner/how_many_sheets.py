print('In this program, we will let you know how many sheets of different values of money you have.')
amountMoney = int(input('Enter your money you have: '))
values = [10000, 5000, 2000, 1000]
sheets = [0, 0, 0, 0]
for i in range(len(values)):
    value = values[i]
    if (amountMoney >= value):
        sheet = amountMoney//value
        amountMoney = amountMoney%value
        sheets[i] = sheet

print('Your sheets you have: ', sheets[0], sheets[1], sheets[2], sheets[3])