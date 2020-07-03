print('In this program, we will let you know how many sheets of different values of money you have.')
amountMoney = int(input('Enter your money you have: '))
amountOf10 = 0
amountOf5 = 0
amountOf2 = 0
amountOf1 = 0
if(amountMoney >= 10000):
    amountOf10 = amountMoney//10000
    amountMoney = amountMoney%10000
if(amountMoney >= 5000):
    amountOf5 = amountMoney//5000
    amountMoney = amountMoney%5000
if(amountMoney >= 2000):
    amountOf2 = amountMoney//2000
    amountMoney = amountMoney%2000
if(amountMoney >= 1000):
    amountOf1 = amountMoney//1000
    amountMoney = amountMoney%1000

print('Your sheets you have: ', amountOf10, amountOf5, amountOf2, amountOf1)