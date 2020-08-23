def main():
    print('Please choose the convert you want ')
    print('1. Decimal to binary')
    print('2. Binary to decimal')
    choice = input('Please enter number you want: ')
    
    if (choice == '1'):
        number = int(input('Enter a number: '))
        result = decimalToBinary(number)
        print(result)
    elif (choice == '2'):
        number = int(input('Enter a binary number: '))
        result = binaryToDecimal(number)
        print(result)
    else:
        print('Invalid choice, you just have two options(1 or 2)')

def decimalToBinary(number):
    temp = ''
    while number != 0:
        temp += str(number%2)
        number = number//2
    return temp[::-1]

def binaryToDecimal(binary):
    decimal = 0
    index = 0
    while binary != 0:
        temp = binary%10
        decimal += temp * (2**index)
        binary = binary//10
        index += 1
    return decimal

main()

