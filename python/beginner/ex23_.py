def main():
    number1 = int(input('Enter number 1: '))
    number2 = int(input('Enter number 2: '))
    number3 = int(input('Enter number 3: '))

    my_sum = number1 + number2 + number3

    if(number1 == number2 and number1 == number3):
        my_sum = my_sum * 3
    
    print('Result: ', my_sum)

main()