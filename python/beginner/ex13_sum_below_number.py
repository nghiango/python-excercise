
def isDivisible4ButNotDivisible5(number):
    return number % 4 == 0 and number % 5 != 0

def main():
    n = int(input('Enter a number: '))
    sumOfAll = 0
    for i in range(4, n):
        if (isDivisible4ButNotDivisible5(i)):
            print('This is my number', i)
            sumOfAll += i
    
    print('Sum of all is:', sumOfAll)

main()